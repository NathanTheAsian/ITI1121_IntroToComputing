public class TextPost extends Post {

    private String message;

    public TextPost(String userName, String message) {
        super(userName);   // call Post constructor
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        String str = new String();
        str = super.toString() + ", " + message;
        return str;
    }

    @Override
    public boolean isPopular() {
        return getLikes() > 50;   // TextPost is popular if more than 50 likes
    }
}