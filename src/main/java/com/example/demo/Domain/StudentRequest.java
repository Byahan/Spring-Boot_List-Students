package com.example.demo.Domain;

import java.time.LocalDate;

public class StudentRequest {
    private String nim;
    private String fullName;
    private LocalDate dob;
    private String address;

    // Getter & Setter wajib ada biar JSON bisa terbaca dari Postman
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
