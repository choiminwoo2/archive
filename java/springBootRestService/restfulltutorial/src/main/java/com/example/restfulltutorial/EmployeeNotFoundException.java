package com.example.restfulltutorial;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super(id + "에 해당하는 직원을 찾을 수 없습니다.");
    }
}
