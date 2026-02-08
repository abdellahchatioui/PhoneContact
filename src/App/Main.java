import Models.Person;
import Ui.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    HashMap<String,String> contacts = new HashMap<String,String>();
    contacts.put("Fatima zahra","0738938983");
    contacts.put("Mohamed chatioui","0650067169");
    contacts.put("Younes iksan","07777777777");

    HashMap<String,String> sentMessages = new HashMap<String,String>();
    sentMessages.put("Fati","ana abdo, mazyan fati");
    sentMessages.put("Toto","ana abdo, mazyan toto");

    HashMap<String,String> receivedMessages = new HashMap<String,String>();
    receivedMessages.put("Zaki","I'm Zaki. hello Abdo");
    receivedMessages.put("Baba","I'm baba. hello Abdo");

    Person person = new Person("Abdellah chatioui","0677633910", contacts, sentMessages,receivedMessages );

    Menu.showMainMenu(person);
}