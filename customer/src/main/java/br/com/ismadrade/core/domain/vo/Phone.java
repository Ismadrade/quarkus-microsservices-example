package br.com.ismadrade.core.domain.vo;

import java.io.Serializable;

public class Phone implements Serializable {

    private Long ddd;
    private Long number;
    private Boolean isCellPhone;

    public Phone(String phone) {
        validate(phone);
    }

    private void validate(String phone){
        String formattedPhone = phone.replaceAll("[()\\- ]", "").trim();

        validateRequiredSizePhone(formattedPhone);
        validateNumberPhone(formattedPhone);


        int firstDigitPhone = Integer.parseInt(formattedPhone.substring(0, 1));
        long ddd = firstDigitPhone == 0 ? Long.parseLong(formattedPhone.substring(0, 3)) : Long.parseLong(formattedPhone.substring(0, 2));
        long number = firstDigitPhone == 0 ? Long.parseLong(formattedPhone.substring(3)) : Long.parseLong(formattedPhone.substring(2));

        validateTypePhone(number);
        validateDDD(ddd);
        validateNumber(number);

        this.ddd = ddd;
        this.number = number;

    }

    private void validateRequiredSizePhone(String phone){
        int numDigits = phone.length();
        if(numDigits < 10 || numDigits > 12)
            throw new IllegalArgumentException("O número de telefone é inválido!");
    }

    private void validateNumberPhone(String phone){
        if (!phone.matches("[0-9]+"))
            throw new IllegalArgumentException("O número do telefone deve conter somente números!");

    }

    private void validateTypePhone(long number){
        int firstDigitNumber = Integer.parseInt(Long.toString(number).substring(0, 1));

        if((firstDigitNumber != 3 && firstDigitNumber != 9) || (firstDigitNumber == 3 && Long.toString(number).length() > 8))
            throw new IllegalArgumentException("O número de telefone é inválido!");

        this.isCellPhone = firstDigitNumber == 9;

    }

    private void validateDDD(Long ddd){
        if(ddd.toString().length() < 2 || ddd.toString().length() > 3 )
            throw new IllegalArgumentException("O número de telefone é inválido!");
    }

    private void validateNumber(Long number){
        if(number.toString().length() < 8  || number.toString().length() > 9 )
            throw new IllegalArgumentException("O número de telefone é inválido!");
    }


    public String getFormattedPhone(){
        return isCellPhone ?
                String.format("(%d) 9 %s - %s", ddd, number.toString().substring(1, 5), number.toString().substring(5,9)) :

                String.format("(%d) %s - %s", ddd, number.toString().substring(0, 4), number.toString().substring(4,8));
    }
}
