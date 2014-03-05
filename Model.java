import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

public class Model {
	private Controller controller;
	private Client client;

	Random generator;

	private String choosenPanelName;
	private String choosenQuestionTag;
	private String choosenQuestionDifficulty;
	private String passwordText;

	private DragDropQuestion emptyDragAndDropQuestion;

	private ArrayList<DragDropMemory> allDragDropQuestions;
	private ArrayList<IQuestion> allMultipleChooiceQuestions;
	private ArrayList<IQuestion> allFillBlankQuestions;


	private ArrayList<IQuestion> choosenQuestionType;
	private ArrayList<IQuestion> choosenQuestions;

	private ArrayList<IQuestion> beginnerPresentTenses;
	private ArrayList<IQuestion> intermediatePresentTenses;
	private ArrayList<IQuestion> advancePresentTenses;

	private ArrayList<IQuestion> beginnerPresentPerfectTenses;
	private ArrayList<IQuestion> intermediatePresentPerfectTenses;
	private ArrayList<IQuestion> advancePresentPerfectTenses;

	private ArrayList<IQuestion> beginnerPastTenses;
	private ArrayList<IQuestion> intermediatePastTenses;
	private ArrayList<IQuestion> advancePastTenses;

	private ArrayList<IQuestion> beginnerPastPerfectTenses;
	private ArrayList<IQuestion> intermediatePastPerfectTenses;
	private ArrayList<IQuestion> advancePastPerfectTenses;

	private ArrayList<IQuestion> beginnerFutureTenses;
	private ArrayList<IQuestion> intermediateFutureTenses;
	private ArrayList<IQuestion> advanceFutureTenses;

	ArrayList<IQuestion> presentTenses = new ArrayList<IQuestion>();
	ArrayList<IQuestion> presentPerfectTenses = new ArrayList<IQuestion>();
	ArrayList<IQuestion> pastTenses = new ArrayList<IQuestion>();
	ArrayList<IQuestion> pastPerfectTenses = new ArrayList<IQuestion>();
	ArrayList<IQuestion> futureTenses = new ArrayList<IQuestion>();

	public Model(Controller controller) throws UnknownHostException,
			IOException {
		this.controller = controller;
		this.choosenPanelName = "CategoryPanel";
		this.choosenQuestionTag = "Present Simple";
		this.choosenQuestionDifficulty = "Beginner";
		this.passwordText = "";
		this.client = new Client();

		generator = new Random();

		this.beginnerPresentTenses = new ArrayList<IQuestion>();
		this.intermediatePresentTenses = new ArrayList<IQuestion>();
		this.advancePresentTenses = new ArrayList<IQuestion>();

		this.beginnerPresentPerfectTenses = new ArrayList<IQuestion>();
		this.intermediatePresentPerfectTenses = new ArrayList<IQuestion>();
		this.advancePresentPerfectTenses = new ArrayList<IQuestion>();

		this.beginnerPastTenses = new ArrayList<IQuestion>();
		this.intermediatePastTenses = new ArrayList<IQuestion>();
		this.advancePastTenses = new ArrayList<IQuestion>();

		this.beginnerPastPerfectTenses = new ArrayList<IQuestion>();
		this.intermediatePastPerfectTenses = new ArrayList<IQuestion>();
		this.advancePastPerfectTenses = new ArrayList<IQuestion>();

		this.beginnerFutureTenses = new ArrayList<IQuestion>();
		this.intermediateFutureTenses = new ArrayList<IQuestion>();
		this.advanceFutureTenses = new ArrayList<IQuestion>();

		readAllFillBlankQuestions();
		readAllMultipleChoiceQuestions();
		readAllDragDropQuestions();

		chooseNewQuestions();
	}
	public void addMultipleChooiceQuestion(GrammarComboBoxQuestion q) throws IOException{
		client.addMultipleChooiceQuestion(q);
		allMultipleChooiceQuestions.add(q);
	}

	public void addFillBlankQuestion(GrammarFillBlankQuestion q) throws IOException{
		client.addFillBlankQuestion(q);
		allFillBlankQuestions.add(q);
	}

	public void setQuestionDifficulty(String questionDifficulty) {
		this.choosenQuestionDifficulty = questionDifficulty;
	}

	public void setQusetionTag(String questionTag) {
		this.choosenQuestionTag = questionTag;

	}

	public void chooseNewQuestions() {
		chooseQuestionType(choosenQuestionTag, choosenQuestionDifficulty);
		chooser(choosenQuestionType);
		for (int i = 0; i < choosenQuestions.size(); i++) {
			choosenQuestions.get(i).reset();
		}
	}

	/*
	 * public void Update(String choosenQuestionDifficulty, String
	 * choosenQuestionTag, boolean getNewQuestions) { if
	 * (choosenQuestionDifficulty != null) { this.choosenQuestionDifficulty =
	 * choosenQuestionDifficulty;
	 * 
	 * } if (choosenQuestionTag != null) { this.choosenQuestionTag =
	 * choosenQuestionTag; }
	 * 
	 * if (getNewQuestions) { controller.report(null, getChoosenQuestions()); }
	 * }
	 */
	public void changePanel(String choosenPanelName) {
		this.choosenPanelName = choosenPanelName;
	}

	/*
	 * public void Update(String choosenPanelName) { this.choosenPanelName =
	 * choosenPanelName; controller.report(choosenPanelName, null); }
	 */



	public void controlAnswer() {
		for (int i = 0; i < choosenQuestions.size(); i++) {
			choosenQuestions.get(i).answerControl();
		}
	}

	public void showAnswer() {
		for (int i = 0; i < choosenQuestions.size(); i++) {
			choosenQuestions.get(i).showAnswer(true);
		}
	}

	public void accessSecurePanel(String password, String choosenPanelName) throws ClassNotFoundException, IOException {
		boolean b = client.passwordControl(password);
		if (b) { // password ile serverdaki password aynı ise

			changePanel(choosenPanelName);
		}
		setPasswordText(b);
	}

	public void setPasswordText(boolean b) {
		if (b)
			passwordText = "";
		else
			passwordText = "Invalid Code";

	}

	private void readAllDragDropQuestions(){
		try {
			allDragDropQuestions = client.getDragDropQuestinos();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < allDragDropQuestions.size(); i++) {



		}
	}

	private void readAllFillBlankQuestions() {
		try {
			allFillBlankQuestions = client.getFillBlankQuestions();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		for (int i = 0; i < allFillBlankQuestions.size(); i++) {
			GrammarFillBlankQuestion q = (GrammarFillBlankQuestion) allFillBlankQuestions
					.get(i);
			chooseQuestionType(q.getTag(), q.getDifficulty());
			choosenQuestionType.add(q);
		}
	}

	private void readAllMultipleChoiceQuestions() {
		try {
			allMultipleChooiceQuestions = client.getMultipleChooiceQuestions();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {
			// 
			e1.printStackTrace();
		}

		for (int i = 0; i < allMultipleChooiceQuestions.size(); i++) {
			GrammarComboBoxQuestion q = (GrammarComboBoxQuestion) allMultipleChooiceQuestions
					.get(i);
			chooseQuestionType(q.getTag(), q.getDifficulty());
			choosenQuestionType.add(q);
		}
	}

	private void chooseQuestionType(String questionTag,
			String questionDifficulty) {
		if (questionTag.equals("Present Tenses")) {
			if (questionDifficulty.equals("Beginner")) {
				choosenQuestionType = (beginnerPresentTenses);
			} else if (questionDifficulty.equals("Intermediate")) {
				choosenQuestionType = (intermediatePresentTenses);
			} else if (questionDifficulty.equals("Advance")) {
				choosenQuestionType = (advancePresentTenses);
			}
		} else if (questionTag.equals("Present Perfect Tenses")) {
			if (questionDifficulty.equals("Beginner")) {
				choosenQuestionType = (beginnerPresentPerfectTenses);
			} else if (questionDifficulty.equals("Intermediate")) {
				choosenQuestionType = (intermediatePresentPerfectTenses);
			} else if (questionDifficulty.equals("Advance")) {
				choosenQuestionType = (advancePresentPerfectTenses);
			}
		} else if (questionTag.equals("Past Tenses")) {
			if (questionDifficulty.equals("Beginner")) {
				choosenQuestionType = (beginnerPastTenses);
			} else if (questionDifficulty.equals("Intermediate")) {
				choosenQuestionType = (intermediatePastTenses);
			} else if (questionDifficulty.equals("Advance")) {
				choosenQuestionType = (advancePastTenses);
			}
		} else if (questionTag.equals("Past Perfect Tenses")) {
			if (questionDifficulty.equals("Beginner")) {
				choosenQuestionType = (beginnerPastPerfectTenses);
			} else if (questionDifficulty.equals("Intermediate")) {
				choosenQuestionType = (intermediatePastPerfectTenses);
			} else if (questionDifficulty.equals("Advance")) {
				choosenQuestionType = (advancePastPerfectTenses);
			}
		} else if (questionTag.equals("Future Tenses")) {
			if (questionDifficulty.equals("Beginner")) {
				choosenQuestionType = (beginnerFutureTenses);
			} else if (questionDifficulty.equals("Intermediate")) {
				choosenQuestionType = (intermediateFutureTenses);
			} else if (questionDifficulty.equals("Advance")) {
				choosenQuestionType = (advanceFutureTenses);
			}
		}
	}

	private void chooser(ArrayList<IQuestion> list) {
		choosenQuestions = new ArrayList<IQuestion>();

		if (list.size() > 10) {
			int numOfChoosen = 0;
			ArrayList<Integer> choosenNum;
			choosenNum = new ArrayList<Integer>();
			while (numOfChoosen < 10) {
				boolean control = true;
				int rndm = (int) (Math.random() * list.size());

				for (int i = 0; i < choosenNum.size(); i++) {
					if (choosenNum.get(i) == rndm) {
						control = false;
						i = choosenNum.size();
					}

				}

				if (control) {
					choosenQuestions.add(list.get(rndm));
					choosenNum.add(rndm);
					numOfChoosen++;

				}
			}

		} else {
			choosenQuestions = list;
		}
	}

	public ArrayList<IQuestion> getChoosenQuestions() {
		return choosenQuestions;
	}

	public String getPasswordText() {
		return passwordText;
	}

	public String getChoosenPanelName() {
		return choosenPanelName;
	}


	public ArrayList<DragDropMemory> getAllDragDropQuestions() {
		return allDragDropQuestions;
	}
	public ArrayList<IQuestion> getAllFillBlankQuestions() {
		return allFillBlankQuestions;
	}
	public void deleteFillBlankQuestion(int numberOfDeletedQuestion) {
		try {
			client.deleteFillBlankQuestion(numberOfDeletedQuestion);
			allFillBlankQuestions.remove(numberOfDeletedQuestion);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteDragDropQuestion(int numberOfDeletedQuestion) {
		try {
			client.deleteDragDropQuestions(numberOfDeletedQuestion);
			allDragDropQuestions.remove(numberOfDeletedQuestion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteMultipleChoiceQuestion(
			int multipleChoiceNumberOfDeletedQuestion) {
		try {
			client.deleteMultipleChoiceQuestions(multipleChoiceNumberOfDeletedQuestion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		allMultipleChooiceQuestions.remove(multipleChoiceNumberOfDeletedQuestion);

	}

	public void addDragDropQuestion() throws IOException{

		DragDropMemory m = new DragDropMemory(emptyDragAndDropQuestion.title, emptyDragAndDropQuestion.Url, emptyDragAndDropQuestion.as);
		allDragDropQuestions.add(m);
		client.addDragDropQuestion(m);
	}

	public ArrayList<IQuestion> getAllMultipleChoiceQuestions() {
		return allMultipleChooiceQuestions;
	}

	//burak
	public ArrayList<IQuestion> getRandomQuestions()
	{
		ArrayList<IQuestion> tmp = new ArrayList<IQuestion>();

		IQuestion tmpQ;
		int randomNumber = 0;
		int sizeOfArray = 0;

		sizeOfArray = beginnerPresentTenses.size();


		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = beginnerPresentTenses.get( randomNumber);
			IQuestion i = tmpQ;
			tmp.add( i);
			presentTenses.add( tmpQ);
		}
		sizeOfArray = intermediatePresentTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = intermediatePresentTenses.get( randomNumber);
			tmp.add( tmpQ);
			presentTenses.add( tmpQ);
		}


		sizeOfArray = advancePresentTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = advancePresentTenses.get( randomNumber);
			tmp.add( tmpQ);
			presentTenses.add( tmpQ);
		}

		sizeOfArray = beginnerPresentPerfectTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = beginnerPresentPerfectTenses.get( randomNumber);
			tmp.add( tmpQ);
			presentPerfectTenses.add( tmpQ);
		}

		sizeOfArray = intermediatePresentPerfectTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = intermediatePresentPerfectTenses.get( randomNumber);
			tmp.add( tmpQ);
			presentPerfectTenses.add( tmpQ);
		}

		sizeOfArray = advancePresentPerfectTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = advancePresentPerfectTenses.get( randomNumber);
			tmp.add( tmpQ);
			presentPerfectTenses.add( tmpQ);
		}

		sizeOfArray = beginnerPastTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = beginnerPastTenses.get( randomNumber);
			tmp.add( tmpQ);
			pastTenses.add( tmpQ);
		}

		sizeOfArray = intermediatePastTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = intermediatePastTenses.get( randomNumber);
			tmp.add( tmpQ);
			pastTenses.add( tmpQ);
		}
		sizeOfArray = advancePastTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = advancePastTenses.get( randomNumber);
			tmp.add( tmpQ);
			pastTenses.add( tmpQ);
		}

		sizeOfArray = beginnerPastPerfectTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = beginnerPastPerfectTenses.get( randomNumber);
			tmp.add( tmpQ);
			pastPerfectTenses.add( tmpQ);
		}

		sizeOfArray = intermediatePastPerfectTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = intermediatePastPerfectTenses.get( randomNumber);
			tmp.add( tmpQ);
			pastPerfectTenses.add( tmpQ);
		}

		sizeOfArray = advancePastPerfectTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = advancePastPerfectTenses.get( randomNumber);
			tmp.add( tmpQ);
			pastPerfectTenses.add( tmpQ);
		}

		sizeOfArray = beginnerFutureTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = beginnerFutureTenses.get( randomNumber);
			tmp.add( tmpQ);
			futureTenses.add( tmpQ);
		}

		//Burdaki soruyu �ekmiyo
		sizeOfArray = intermediateFutureTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = intermediateFutureTenses.get( randomNumber);
			tmp.add( tmpQ);
			futureTenses.add( tmpQ);
		}

		sizeOfArray = advanceFutureTenses.size();
		if( sizeOfArray != 0)
		{
			randomNumber = generator.nextInt( sizeOfArray);
			tmpQ = advanceFutureTenses.get( randomNumber);
			tmp.add( tmpQ);
			futureTenses.add( tmpQ);
		}

		return tmp;
	}

	public int presentScore()
	{

		int point = 0;
		if( presentTenses.get(0).answerControl())
		{
			point = point + 2;
		}
		if( presentTenses.get(1).answerControl())
		{
			point = point + 3;
		}
		if( presentTenses.get(2).answerControl())
		{
			point = point + 5;
		}



		for( int i = 0; i < pastTenses.size(); i++)
		{
			presentTenses.get(i).reset();
		}
		presentTenses.remove(0);
		presentTenses.remove(0);
		presentTenses.remove(0);
		return point;
	}

	public int presentPerfectScore()
	{
		int point = 0;
		if( presentPerfectTenses.get(0).answerControl())
		{
			point = point + 2;
		}
		if( presentPerfectTenses.get(1).answerControl())
		{
			point = point + 3;
		}
		if( presentPerfectTenses.get(2).answerControl())
		{
			point = point + 5;
		}	

		for( int i = 0; i < pastTenses.size(); i++)
		{
			presentPerfectTenses.get(i).reset();
		}
		presentPerfectTenses.remove(0);
		presentPerfectTenses.remove(0);
		presentPerfectTenses.remove(0);
		return point;
	}

	public int pastScore()
	{
		int point = 0;
		if( pastTenses.get(0).answerControl())
		{
			point = point + 2;
		}
		if( pastTenses.get(1).answerControl())
		{
			point = point + 3;
		}
		if( pastTenses.get(2).answerControl())
		{
			point = point + 5;
		}	

		for( int i = 0; i < pastTenses.size(); i++)
		{
			pastTenses.get(i).reset();
		}
		pastTenses.remove(0);
		pastTenses.remove(0);
		pastTenses.remove(0);
		return point;
	}

	public int pastPerfectScore()
	{
		int point = 0;
		if( pastPerfectTenses.get(0).answerControl())
		{
			point = point + 2;
		}
		if( pastPerfectTenses.get(1).answerControl())
		{
			point = point + 3;
		}
		if( pastPerfectTenses.get(2).answerControl())
		{
			point = point + 5;
		}	

		for( int i = 0; i < pastTenses.size(); i++)
		{
			pastPerfectTenses.get(i).reset();
		}
		pastPerfectTenses.remove(0);
		pastPerfectTenses.remove(0);
		pastPerfectTenses.remove(0);
		return point;
	}

	public int futureScore()
	{
		int point = 0;
		if( futureTenses.get(0).answerControl())
		{
			point = point + 2;
		}
		if( futureTenses.get(1).answerControl())
		{
			point = point + 3;
		}
		if( futureTenses.get(2).answerControl())
		{
			point = point + 5;
		}	

		for( int i = 0; i < pastTenses.size(); i++)
		{
			futureTenses.get(i).reset();
		}
		futureTenses.remove(0);
		futureTenses.remove(0);
		futureTenses.remove(0);
		return point;
	}

	public void createEmptyDragAndDropQuestion(Controller controller, String title, String Url, boolean teacherModeOn){
		emptyDragAndDropQuestion = new DragDropQuestion(controller,title,  Url,new ArrayList<Box>(), teacherModeOn);
	}

	public DragDropQuestion getEmptyDragDropQuestion(){
		return emptyDragAndDropQuestion;
	}
	public DragDropQuestion getRandomDragDrop(){
		int i = allDragDropQuestions.size();
		int b = (int) (Math.random()*i);
		DragDropMemory m = allDragDropQuestions.get(b);
		DragDropQuestion q = new DragDropQuestion(controller, m.getTitle(), m.getUrl(), m.getAs(), false);
		q.reset();
		return q;
	}

}
