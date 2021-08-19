package com.employee.payroll.vo;

public class Pair<Valid, Invalid> {
    Valid valid;
    Invalid invalid;
    public Pair(Valid valid, Invalid invalid){
        this.valid = valid;
        this.invalid = invalid;
    }

    public Valid getValid(){
        return valid;
    }
    public Invalid getInvalid(){
        return invalid;
    }
}
