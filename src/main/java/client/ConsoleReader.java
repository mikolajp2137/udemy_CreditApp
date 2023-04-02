package client;

import core.model.*;

import java.util.Scanner;

public class ConsoleReader {
    public CreditApplication readInputParameters() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.next();

        System.out.println("Enter your last name: ");
        String lastName = input.next();

        System.out.println("Enter your mother's maiden name: ");
        String mothersMaidenName = input.next();

        System.out.println("What is your marital status? (SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED): ");
        MaritalStatus maritalStatus = MaritalStatus.valueOf(input.next());

        System.out.println("What is your education level? (NONE, PRIMARY, MIDDLE, SECONDARY, POST_SECONDARY, TERTIARY): ");
        Education education = Education.valueOf(input.next());

        System.out.println("Enter your email address: ");
        String email = input.next();

        System.out.println("Enter your phone number: ");
        String phoneNumber = input.next();

        System.out.println("Enter total monthly income in PLN: ");
        double income = input.nextDouble();

        System.out.println("Enter number of family dependants (including applicant): ");
        int numOfDependant = input.nextInt();

        System.out.println("What is purpose of loan? (MORTGAGE, PERSONAL_LOAN) ");
        LoanType loanType = LoanType.valueOf(input.next());

        System.out.println("Enter loan amount: ");
        double loanAmount = input.nextDouble();

        System.out.println("Enter loan period (in years): ");
        byte period = input.nextByte();

        PersonalData personalData = new PersonalData(name, lastName, mothersMaidenName, income, maritalStatus, education, numOfDependant);
        ContactData contactData = new ContactData(email, phoneNumber);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, loanAmount, period);

        return new CreditApplication(new Person(personalData,contactData), purposeOfLoan);
    }
}
