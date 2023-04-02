import client.ConsoleReader;
import core.CreditApplicationService;
import core.model.CreditApplication;
import core.model.Person;
import core.model.PersonalData;

public class Main {
    public static void main(String[] args) {
        CreditApplicationService service = new CreditApplicationService();
        CreditApplication creditApplication = new ConsoleReader().readInputParameters();

        String decision = service.getDecision(creditApplication);
        System.out.println(decision);
    }
}