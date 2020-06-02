import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TO DO: First name first char is Uppercase, same applies for Last name as does for first name and address
public class ListApp {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menuRender();
        selector();
    }

    /**
     * Метод който визуализира менюто
     */
    public static void menuRender(){
        System.out.println("Copy and paste one of the commands you wish to execute and then input the parameter:");
        System.out.println();
        System.out.println("SELECT");
        System.out.println("SELECT{TYPE}=[Input type]");
        System.out.println("SELECT{SPECIAL_PROPERTY}::{KID}=[{KFNAME}=[Input kid's name]]");
        System.out.println("SELECT{TYPE}=[Input type]@{SEX}=[Input sex]");
        System.out.println("SELECT{FNAME}=[Input first name]");
        System.out.println("SELECT{AGE}=[Input age]");
    }

    /**
     * Метод който изпечатва в конзолата всички граждани въведени в получения текст
     * @throws IOException
     */
    public static void fullSelector() throws IOException {
        File fileReference = new File("resources/List");
        FileReader fileReferenceReader = new FileReader(fileReference);
        BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);
        StringBuilder stringBuilder = new StringBuilder();
        String lines;

        while ((lines = bufferedReader.readLine()) != null) {
            String[] secondSplitter = lines.split("\\[");
            //type
            String typeString = secondSplitter[1];
            String[] typeSplitter = typeString.split("]");
            String type = typeSplitter[0];
            //first name
            String firstNameString = secondSplitter[2];
            String[] firstNameSplitter = firstNameString.split("]");
            String firstName = firstNameSplitter[0];
            if(containsNumbers(firstName)){
                firstName = "Invalid first name";
            }
            String finalFirstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
            //last name
            String lastNameString = secondSplitter[3];
            String[] lastNameSplitter = lastNameString.split("]");
            String lastName = lastNameSplitter[0];
            if(containsNumbers(lastName)){
                lastName = "Invalid last name";
            }
            String finalLastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
            //age
            String ageString = secondSplitter[4];
            String[] ageSplitter = ageString.split("]");
            String age = ageSplitter[0];
            int ageNumber = Integer.parseInt(ageSplitter[0]);
            if (ageNumber < 0 || ageNumber > 150) {
                age = "Invalid age";
            }
            //sex
            String sexString = secondSplitter[5];
            String[] sexSplitter = sexString.split("]");
            String sex = sexSplitter[0];
            //address
            String addressString = secondSplitter[6];
            String[] addressSplitter = addressString.split("]");
            String address = addressSplitter[0];
            if(containsNumbers(address)){
                address = "Invalid address";
            }
            String finalAddress = address.substring(0,1).toUpperCase()+address.substring(1);
            //phone
            String phoneString = secondSplitter[7];
            String[] phoneSplitter = phoneString.split("]");
            String phone = phoneSplitter[0];
            String special;
            if (type.equals("M")) {

                String firstNameKidString = secondSplitter[9];
                String[] firstNameKidSplitter = firstNameKidString.split("]");
                String firstNameKid = firstNameKidSplitter[0];

                String lastNameKidString = secondSplitter[10];
                String[] lastNameKidSplitter = lastNameKidString.split("]");
                String lastNameKid = lastNameKidSplitter[0];

                String ageKidString = secondSplitter[11];
                String[] ageKidSplitter = ageKidString.split("]");
                String ageKid = ageKidSplitter[0];

                System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + firstNameKid + " " + lastNameKid + " " + ageKid);
            } else {
                String specialString = secondSplitter[8];
                String[] specialSplitter = specialString.split("]");
                special = specialSplitter[0];
                System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + special);
            }
        }
    }

    /**
     * Метод който при който при подаване на тип или типове чрез конзолата се изпечатват граждани отговарящи на този тип.
     * @throws IOException
     */
    public static void selector() throws IOException {
        String input = scanner.nextLine();
        switch (input) {
            case "SELECT{FNAME}=[Input first name]":
                System.out.print("Input first name: ");
                firstNameSelector();
                break;
            case "SELECT{AGE}=[Input age]":
                System.out.print("Input age: ");
                ageSelector();
                break;
            case "SELECT{TYPE}=[Input type]@{SEX}=[Input sex]":
                System.out.print("Input type: ");
                retiredSelector();
                break;
            case "SELECT{SPECIAL_PROPERTY}::{KID}=[{KFNAME}=[Input kid's name]]":
                System.out.print("Input kid's name: ");
                kidSelector();
                break;
            case "SELECT{TYPE}=[Input type]":
                System.out.print("Input type: ");
                typeSelector();
                break;
            case "SELECT":
                fullSelector();
                break;
            default:
                System.err.println("Invalid selection");
        }
    }

    /**
     * Метод който чете текст от текстов файл и отпечатва гражданите отговарящи на въведен параметър от конзолата.
     * @throws IOException
     */
    public static void typeSelector() throws IOException {
        String typeInput = scanner.nextLine();

        File fileReference = new File("resources/List");
        FileReader fileReferenceReader = new FileReader(fileReference);
        BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);

        String lines;

        while ((lines = bufferedReader.readLine()) != null){
        String[] secondSplitter = lines.split("\\[");
        //type
        String typeString = secondSplitter[1];
        String[] typeSplitter = typeString.split("]");
        String type = typeSplitter[0];
        //first name
        String firstNameString = secondSplitter[2];
        String[] firstNameSplitter = firstNameString.split("]");
        String firstName = firstNameSplitter[0];
        if(containsNumbers(firstName)){
                firstName = "Invalid first name";
        }
        String finalFirstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
        //last name
        String lastNameString = secondSplitter[3];
        String[] lastNameSplitter = lastNameString.split("]");
        String lastName = lastNameSplitter[0];
        if(containsNumbers(lastName)){
                lastName = "Invalid last name";
        }
        String finalLastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
        //age
        String ageString = secondSplitter[4];
        String[] ageSplitter = ageString.split("]");
        String age = ageSplitter[0];
        int ageNumber = Integer.parseInt(ageSplitter[0]);
        if(ageNumber<0||ageNumber>150){
            age = "Invalid age";
        }
        //sex
        String sexString = secondSplitter[5];
        String[] sexSplitter = sexString.split("]");
        String sex = sexSplitter[0];
        //address
        String addressString = secondSplitter[6];
        String[] addressSplitter = addressString.split("]");
        String address = addressSplitter[0];
        if(containsNumbers(address)){
                address = "Invalid address";
        }
        String finalAddress = address.substring(0,1).toUpperCase()+address.substring(1);
        //phone
        String phoneString = secondSplitter[7];
        String[] phoneSplitter = phoneString.split("]");
        String phone = phoneSplitter[0];
        String special;
        if (type.equals(typeInput)) {
            if (typeInput.equals("M")) {
                String firstNameKidString = secondSplitter[9];
                String[] firstNameKidSplitter = firstNameKidString.split("]");
                String firstNameKid = firstNameKidSplitter[0];

                String lastNameKidString = secondSplitter[10];
                String[] lastNameKidSplitter = lastNameKidString.split("]");
                String lastNameKid = lastNameKidSplitter[0];

                String ageKidString = secondSplitter[11];
                String[] ageKidSplitter = ageKidString.split("]");
                String ageKid = ageKidSplitter[0];

                System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + firstNameKid + " " + lastNameKid + " " + ageKid);
            } else {
                String specialString = secondSplitter[8];
                String[] specialSplitter = specialString.split("]");
                special = specialSplitter[0];
                System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + special);
            }
        }
        }
    }

    /**
     * Метод който чете текст от текстов файл и отпечатва гражданите отговарящи на въведен параметър от конзолата.
     * @throws IOException
     */
    public static void kidSelector() throws IOException {
        String kidNameInput = scanner.nextLine();

        File fileReference = new File("resources/List");
        FileReader fileReferenceReader = new FileReader(fileReference);
        BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);

        String lines;

        while ((lines = bufferedReader.readLine()) != null) {
            String[] secondSplitter = lines.split("\\[");
            //type
            String typeString = secondSplitter[1];
            String[] typeSplitter = typeString.split("]");
            String type = typeSplitter[0];
            //first name
            String firstNameString = secondSplitter[2];
            String[] firstNameSplitter = firstNameString.split("]");
            String firstName = firstNameSplitter[0];
            if(containsNumbers(firstName)){
                firstName = "Invalid first name";
            }
            String finalFirstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
            //last name
            String lastNameString = secondSplitter[3];
            String[] lastNameSplitter = lastNameString.split("]");
            String lastName = lastNameSplitter[0];
            if(containsNumbers(lastName)){
                lastName = "Invalid last name";
            }
            String finalLastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
            //age
            String ageString = secondSplitter[4];
            String[] ageSplitter = ageString.split("]");
            String age = ageSplitter[0];
            int ageNumber = Integer.parseInt(ageSplitter[0]);
            if (ageNumber < 0 || ageNumber > 150) {
                age = "Invalid age";
            }
            //sex
            String sexString = secondSplitter[5];
            String[] sexSplitter = sexString.split("]");
            String sex = sexSplitter[0];
            //address
            String addressString = secondSplitter[6];
            String[] addressSplitter = addressString.split("]");
            String address = addressSplitter[0];
            if(containsNumbers(address)){
                address = "Invalid address";
            }
            String finalAddress = address.substring(0,1).toUpperCase()+address.substring(1);
            //phone
            String phoneString = secondSplitter[7];
            String[] phoneSplitter = phoneString.split("]");
            String phone = phoneSplitter[0];
            if (type.equals("M")) {

                String firstNameKidString = secondSplitter[9];
                String[] firstNameKidSplitter = firstNameKidString.split("]");
                String firstNameKid = firstNameKidSplitter[0];

                String lastNameKidString = secondSplitter[10];
                String[] lastNameKidSplitter = lastNameKidString.split("]");
                String lastNameKid = lastNameKidSplitter[0];

                String ageKidString = secondSplitter[11];
                String[] ageKidSplitter = ageKidString.split("]");
                String ageKid = ageKidSplitter[0];
                if (kidNameInput.equals(firstNameKid)) {
                    System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + firstNameKid + " " + lastNameKid + " " + ageKid);
                }
            }
        }
    }

    /**
     * Метод който чете текст от текстов файл и отпечатва гражданите отговарящи на въведен параметър от конзолата.
     * @throws IOException
     */
    public static void retiredSelector() throws IOException {
        String typeInput = scanner.nextLine();
        System.out.print("Input sex: ");
        String sexInput = scanner.nextLine();

        File fileReference = new File("resources/List");
        FileReader fileReferenceReader = new FileReader(fileReference);
        BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);

        String lines;

        while ((lines = bufferedReader.readLine()) != null){
        String[] secondSplitter = lines.split("\\[");
        //type
        String typeString = secondSplitter[1];
        String[] typeSplitter = typeString.split("]");
        String type = typeSplitter[0];
        //first name
        String firstNameString = secondSplitter[2];
        String[] firstNameSplitter = firstNameString.split("]");
        String firstName = firstNameSplitter[0];
        if(containsNumbers(firstName)){
                firstName = "Invalid first name";
        }
        String finalFirstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
        //last name
        String lastNameString = secondSplitter[3];
        String[] lastNameSplitter = lastNameString.split("]");
        String lastName = lastNameSplitter[0];
        if(containsNumbers(lastName)){
                lastName = "Invalid last name";
        }
        String finalLastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
        //age
        String ageString = secondSplitter[4];
        String[] ageSplitter = ageString.split("]");
        String age = ageSplitter[0];
        int ageNumber = Integer.parseInt(ageSplitter[0]);
        if(ageNumber<0||ageNumber>150){
            age = "Invalid age";
        }
        //sex
        String sexString = secondSplitter[5];
        String[] sexSplitter = sexString.split("]");
        String sex = sexSplitter[0];
        //address
        String addressString = secondSplitter[6];
        String[] addressSplitter = addressString.split("]");
        String address = addressSplitter[0];
        if(containsNumbers(address)){
                address = "Invalid address";
        }
        String finalAddress = address.substring(0,1).toUpperCase()+address.substring(1);
        //phone
        String phoneString = secondSplitter[7];
        String[] phoneSplitter = phoneString.split("]");
        String phone = phoneSplitter[0];
        String special;
        String specialString = secondSplitter[8];
        String[] specialSplitter = specialString.split("]");
        special = specialSplitter[0];
        if (typeInput.equals(type)) {
            if (sexInput.equals(sex)) {
                System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + special);
            }
        }
        }
    }

    /**
     * Метод който чете текст от текстов файл и отпечатва гражданите отговарящи на въведен параметър от конзолата.
     * @throws IOException
     */
    public static void ageSelector() throws IOException {
        String ageInput = scanner.nextLine();

        int inputNumber = Integer.parseInt(ageInput);
        if (inputNumber<0 || inputNumber>150){
            System.err.println("Invalid age");
            System.exit(0);
        }

        File fileReference = new File("resources/List");
        FileReader fileReferenceReader = new FileReader(fileReference);
        BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);

        String lines;

        while ((lines = bufferedReader.readLine()) != null) {
            String[] secondSplitter = lines.split("\\[");
            //type
            String typeString = secondSplitter[1];
            String[] typeSplitter = typeString.split("]");
            String type = typeSplitter[0];
            //first name
            String firstNameString = secondSplitter[2];
            String[] firstNameSplitter = firstNameString.split("]");
            String firstName = firstNameSplitter[0];
            if(containsNumbers(firstName)){
                firstName = "Invalid first name";
            }
            String finalFirstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
            //last name
            String lastNameString = secondSplitter[3];
            String[] lastNameSplitter = lastNameString.split("]");
            String lastName = lastNameSplitter[0];
            if(containsNumbers(lastName)){
                lastName = "Invalid last name";
            }
            String finalLastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
            //age
            String ageString = secondSplitter[4];
            String[] ageSplitter = ageString.split("]");
            String age = ageSplitter[0];
            //sex
            String sexString = secondSplitter[5];
            String[] sexSplitter = sexString.split("]");
            String sex = sexSplitter[0];
            //address
            String addressString = secondSplitter[6];
            String[] addressSplitter = addressString.split("]");
            String address = addressSplitter[0];
            if(containsNumbers(address)){
                address = "Invalid address";
            }
            String finalAddress = address.substring(0,1).toUpperCase()+address.substring(1);
            //phone
            String phoneString = secondSplitter[7];
            String[] phoneSplitter = phoneString.split("]");
            String phone = phoneSplitter[0];
            String special;
            if (ageInput.equals(age)) {
                if (type.equals("M")) {
                    String firstNameKidString = secondSplitter[9];
                    String[] firstNameKidSplitter = firstNameKidString.split("]");
                    String firstNameKid = firstNameKidSplitter[0];

                    String lastNameKidString = secondSplitter[10];
                    String[] lastNameKidSplitter = lastNameKidString.split("]");
                    String lastNameKid = lastNameKidSplitter[0];

                    String ageKidString = secondSplitter[11];
                    String[] ageKidSplitter = ageKidString.split("]");
                    String ageKid = ageKidSplitter[0];

                    System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + firstNameKid + " " + lastNameKid + " " + ageKid);
                } else {
                    String specialString = secondSplitter[8];
                    String[] specialSplitter = specialString.split("]");
                    special = specialSplitter[0];
                    System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + special);
                }
            }
        }
    }

    /**
     * Метод който чете текст от текстов файл и отпечатва гражданите отговарящи на въведен параметър от конзолата.
     * @throws IOException
     */
    public static void firstNameSelector() throws IOException {
        String firstNameInput = scanner.nextLine();

        File fileReference = new File("resources/List");
        FileReader fileReferenceReader = new FileReader(fileReference);
        BufferedReader bufferedReader = new BufferedReader(fileReferenceReader);

        String lines;

        while ((lines = bufferedReader.readLine()) != null) {
            String[] secondSplitter = lines.split("\\[");
            //type
            String typeString = secondSplitter[1];
            String[] typeSplitter = typeString.split("]");
            String type = typeSplitter[0];
            //first name
            String firstNameString = secondSplitter[2];
            String[] firstNameSplitter = firstNameString.split("]");
            String firstName = firstNameSplitter[0];
            if(containsNumbers(firstName)){
                firstName = "Invalid first name";
            }
            String finalFirstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
            //last name
            String lastNameString = secondSplitter[3];
            String[] lastNameSplitter = lastNameString.split("]");
            String lastName = lastNameSplitter[0];
            if(containsNumbers(lastName)){
                lastName = "Invalid last name";
            }
            String finalLastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
            //age
            String ageString = secondSplitter[4];
            String[] ageSplitter = ageString.split("]");
            String age = ageSplitter[0];
            int ageNumber = Integer.parseInt(ageSplitter[0]);
            if (ageNumber < 0 || ageNumber > 150) {
                age = "Invalid age";
            }
            //sex
            String sexString = secondSplitter[5];
            String[] sexSplitter = sexString.split("]");
            String sex = sexSplitter[0];
            //address
            String addressString = secondSplitter[6];
            String[] addressSplitter = addressString.split("]");
            String address = addressSplitter[0];
            if(containsNumbers(address)){
                address = "Invalid address";
            }
            String finalAddress = address.substring(0,1).toUpperCase()+address.substring(1);
            //phone
            String phoneString = secondSplitter[7];
            String[] phoneSplitter = phoneString.split("]");
            String phone = phoneSplitter[0];
            String special;
            if (firstNameInput.equals(firstName)) {
                if (type.equals("M")) {
                    String firstNameKidString = secondSplitter[9];
                    String[] firstNameKidSplitter = firstNameKidString.split("]");
                    String firstNameKid = firstNameKidSplitter[0];

                    String lastNameKidString = secondSplitter[10];
                    String[] lastNameKidSplitter = lastNameKidString.split("]");
                    String lastNameKid = lastNameKidSplitter[0];

                    String ageKidString = secondSplitter[11];
                    String[] ageKidSplitter = ageKidString.split("]");
                    String ageKid = ageKidSplitter[0];

                    System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + firstNameKid + " " + lastNameKid + " " + ageKid);
                } else {
                    String specialString = secondSplitter[8];
                    String[] specialSplitter = specialString.split("]");
                    special = specialSplitter[0];
                    System.out.println(finalFirstName + " | " + finalLastName + " | " + age + " | " + finalAddress + " | " + sex + " | " + special);
                }
            }
        }
    }

    /**
     * Метод който проверява дали подаден текст съдържа цифри.
     * @param string проверяваният текст от метода.
     * @return True ако текстът съдържа цифри и false ако не съдържа.
     */
    public static boolean containsNumbers(String string){
        Pattern p = Pattern.compile( "[0-9]" );
        Matcher m = p.matcher( string );

        return m.find();
    }
}