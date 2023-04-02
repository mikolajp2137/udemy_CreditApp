package core;

import core.model.Person;

public class PersonScoringCalculator {
    public int calculate(Person person) {
        double incomePerFamilyMember = person.getIncomePerFamilyMember();
        int pointsForIncome = (int) (incomePerFamilyMember / 1000) * 100;
        int pointsForMaritalStatus = person.getPersonalData().getMarried().getScoringPoints();
        int pointsForEducation = person.getPersonalData().getEducation().getScoringPoints();


        return pointsForIncome + pointsForMaritalStatus + pointsForEducation;
    }
}
