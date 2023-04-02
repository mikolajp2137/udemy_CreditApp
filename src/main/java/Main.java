import client.ConsoleReader;
import core.CreditApplicationDecision;
import core.CreditApplicationService;
import core.PersonScoringCalculator;
import core.model.CreditApplication;

public class Main {
    public static void main(String[] args) {
        CreditApplicationService service = new CreditApplicationService(new PersonScoringCalculator());
        CreditApplication creditApplication = new ConsoleReader().readInputParameters();

        CreditApplicationDecision decision = service.getDecision(creditApplication);
        System.out.println(decision.getDecisionString());
    }
}