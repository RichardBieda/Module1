package Module1_Final_Project;

class NotValidKey extends RuntimeException{

    NotValidKey() {}

    NotValidKey(String text) {
        super(text);
    }
}
