package businessObjects;

import pageObjects.ComposePage;
import pageObjects.IncomeLettersPage;
import pageObjects.InitialPage;
import pageObjects.SentLettersPage;

public class GmailBO {

    private InitialPage initialPage;
    private IncomeLettersPage incomeLettersPage;
    private ComposePage composePage;
    private SentLettersPage sentLettersPage;

    public GmailBO() {
        initialPage = new InitialPage();
        incomeLettersPage = new IncomeLettersPage();
        composePage = new ComposePage();
        sentLettersPage = new SentLettersPage();
    }

    public GmailBO skipInitialPage() {
        initialPage
            .clickGotItBtn()
            .clickTakeMeToGmailBtn();
        return this;
    }

    public GmailBO sendLetter(String recipient, String subject, String body) {
        incomeLettersPage
            .clickComposeBtn();
        composePage
            .clickGotItBtn()
            .typeRecipient(recipient)
            .typeSubject(subject)
            .typeBody(body)
            .clickSendBtn();
        return this;
    }

    public GmailBO openSentLetters() {
        incomeLettersPage
            .clickNavDrawerBtn()
            .clickSentBtn();
        return this;
    }

    public boolean isLetterSent(String subject) throws InterruptedException {
        Thread.sleep(3000);
        return sentLettersPage.isSentLetterDisplayed(subject);
    }
}
