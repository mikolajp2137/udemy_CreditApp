package core;

import core.model.CreditApplication;
import core.model.Person;

import java.math.BigDecimal;

public class CreditApplicationService {
    private final PersonScoringCalculator calculator;

    public CreditApplicationService(PersonScoringCalculator calculator) {
        this.calculator = calculator;
    }

    public CreditApplicationDecision getDecision(CreditApplication creditApplication) {
        Person person = creditApplication.getPerson();
        int scoring = calculator.calculate(person);

        if (scoring < 300) {
            return new CreditApplicationDecision(DecisionType.NEGATIVE_RATING,person.getPersonalData(), null);
        } else if (scoring <= 400) {
            return new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED,person.getPersonalData(), null);
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
            return new CreditApplicationDecision(DecisionType.POSITIVE,person.getPersonalData(), creditRate);
        } else {
            return new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING,person.getPersonalData(), creditRate);
        }


    }

}
