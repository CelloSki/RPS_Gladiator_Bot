package src;

public class Object {
    public enum GameObject {ROCK, PAPER, SCISSORS}
    private GameObject gameObject;

    //----------------------------------------------------------------------------------------
    // Default constructor
    //----------------------------------------------------------------------------------------
    public Object() {
        gameObject = null;
    }

    //----------------------------------------------------------------------------------------
    // Constructor to set Player's Object Instantly
    //----------------------------------------------------------------------------------------
    public Object(int objectId) {
        setGameObject(objectId);
    }

    //----------------------------------------------------------------------------------------
    // Method to get currentGameObject
    //----------------------------------------------------------------------------------------
    public GameObject getGameObject() {
        return gameObject;
    }

    //----------------------------------------------------------------------------------------
    //  Method to set gameObject
    //----------------------------------------------------------------------------------------
    public void setGameObject(int objectID) {
       switch (objectID) {
            case 1:
                gameObject = GameObject.ROCK;
                break;
            case 2:
                gameObject = GameObject.PAPER;
                break;
            case 3:
                gameObject = GameObject.SCISSORS;
                break;
            default:
                gameObject = null;
        }
    }

}
