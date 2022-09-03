package org.frank.microboot.vo;

import org.junit.jupiter.api.Test;

public class EmpTest {
    
    @Test
    public void test(){
        Emp emp1 = new Emp(1l,"a",3.2);
        Emp emp2 = new Emp();
        Emp emp3 = Emp.setNonnull(2l,"ad");
        
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
    }
}
