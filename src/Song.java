public class Song {
    //every song has name and duration attributes
    public String name;
    public double duration;

    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }
    public String toString(){
        return "Now : Playing Song :"+name+", duration :"+duration;
    }
}
