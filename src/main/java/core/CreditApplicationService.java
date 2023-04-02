package core;

import core.model.CreditApplication;
import core.model.Person;

import java.math.BigDecimal;

public class CreditApplicationService {
    public String getDecision(CreditApplication creditApplication) {
        Person person = creditApplication.getPerson();
        PersonScoringCalculator calculator = new PersonScoringCalculator();
        String decisionNegative = "Sorry " + person.getPersonalData().getName() + " " + person.getPersonalData().getLastName() + ", decision is negative";
        String decisionPositive = "Congratulations  " + person.getPersonalData().getName() + " " + person.getPersonalData().getLastName() + ", decision is positive";
        String decisionIndecisive = "Sorry  " + person.getPersonalData().getName() + " " + person.getPersonalData().getLastName() + ", bank requires additional documents. Our consultant will contact you.";
        int scoring = calculator.calculate(person);

        if (scoring < 300) {
            return decisionNegative;
        } else if (scoring <= 400) {
            return decisionIndecisive;
        }
        double creditRate = person.getIncomePerFamilyMember() * 12 * creditApplication.getPurposeOfLoan().getPeriod();
        switch (creditApplication.getPurposeOfLoan().getLoanType()) {
            case PERSONAL_LOAN:
                creditRate *= Constants.PERSONAL_LOAN_RATE;
                break;
            case MORTGAGE:
                creditRate *= Constants.MORTGAGE_LOAN_RATE;
        }

        if (creditRate >= creditApplication.getPurposeOfLoan().getAmount()) {
            return decisionPositive;
        } else {
            BigDecimal roundedCreditRate = new BigDecimal(creditRate).setScale(2);
            return "Sorry " + person.getPersonalData().getName() + " " + person.getPersonalData().getLastName() + ", decision is negative, bank can only borrow you only " + roundedCreditRate + " PLN";
        }


    }

}
