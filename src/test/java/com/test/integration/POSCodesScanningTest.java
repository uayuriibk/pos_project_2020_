package com.test.integration;

import com.test.POS;
import com.test.POSBuilder;
import com.test.POSBuildingDirector;
import com.test.StandartPOSBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class POSCodesScanningTest {

    private String[] codesForScanning;

    private BigDecimal expectedResult;

    public POSCodesScanningTest(String[] toScan, BigDecimal expectedResult){
        this.codesForScanning = toScan;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp(){
        POSBuildingDirector director = new POSBuildingDirector();
        POSBuilder standardPointOfSale = new StandartPOSBuilder();
        director.setPosBuilder(standardPointOfSale);
        director.constructPointOfSale();
        director.getPointOfSale().getScanner().setProductsPrices(DataForTestUtility.getProductsInfoDB());
    }

    @Test
    public void successfulGetTotal() {
        for (String code : codesForScanning) {
            POS.getInstance().processInput(code);
        }
        assertEquals(expectedResult, POS.getInstance().getScanner().calculateTotalPrice());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return DataForTestUtility.getData();
    }

}
