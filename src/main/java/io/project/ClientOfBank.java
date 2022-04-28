package io.project;

public class ClientOfBank {

    public ClientOfBank(String name, String surname, String country, String bank) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.bank = bank;
    }



    @JsonElement()
    private String name;

    @JsonElement()
    private String surname;


    @JsonElement()
    private String country;

    @JsonElement
    private String bank;


}
