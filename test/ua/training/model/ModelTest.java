package ua.training.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    /**
     * Test if secret number may have all of the range values
     */
    @Test
    public void testSettingSecretValue(){
        Model model = new Model();
        model.setMinLimit(1);
        model.setMaxLimit(100);
        boolean [] arr = new boolean[(model.getMaxLimit()-model.getMinLimit()+1)];
        for(int i = 0;i<1000000;i++){
            model.setGuessedNumber();
            arr[model.getGuessedNumber()] = true;
        }
        for (int i = model.getMinLimit();i<model.getMaxLimit();i++) {
            System.out.println(arr[i]);
            Assert.assertTrue(arr[i]);
        }
    }

}