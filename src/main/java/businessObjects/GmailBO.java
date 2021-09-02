package businessObjects;

import pageObjects.ComposePage;
import pageObjects.IncomeLettersPage;
import pageObjects.InitialPage;
import pageObjects.SentLettersPage;

public class GmailBO {

    public GmailBO skipInitialPage() {
        new InitialPage()
            .clickGotItBtn()
            .clickTakeMeToGmailBtn();
        return this;
    }

    public GmailBO sendLetter(String recipient, String subject, String body) {
        new IncomeLettersPage()
            .clickComposeBtn();
        new ComposePage()
            .clickGotItBtn()
            .typeRecipient(recipient)
            .typeSubject(subject)
            .typeBody(body)
            .clickSendBtn();
        return this;
    }

    public GmailBO openSentLetters() {
        new IncomeLettersPage()
            .clickNavDrawerBtn()
            .clickSentBtn();
        return this;
    }

    public boolean isLetterSent(String subject) throws InterruptedException {
        return new SentLettersPage().isSentLetterDisplayed(subject);
    }
}
