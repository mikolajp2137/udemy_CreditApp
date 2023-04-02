package core.model;

public class PersonalData {
    public PersonalData(String name, String lastName, String mothersMaidenName, double totalMonthlyIncomeInPLN, MaritalStatus married, Education education, int numOfFamilyDependants) {
        this.name = name;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.totalMonthlyIncomeInPLN = totalMonthlyIncomeInPLN;
        this.married = married;
        this.education = education;
        this.numOfFamilyDependants = numOfFamilyDependants;
    }

    private final String name;
    private final String lastName;
    private final String mothersMaidenName;
    private final double totalMonthlyIncomeInPLN;
    private final MaritalStatus married;
    private final Education education;
    private final int numOfFamilyDependants;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public double getTotalMonthlyIncomeInPLN() {
        return totalMonthlyIncomeInPLN;
    }

    public MaritalStatus getMarried() {
        return married;
    }

    public Education getEducation() {
        return education;
    }

    public int getNumOfFamilyDependants() {
        return numOfFamilyDependants;
    }
}
