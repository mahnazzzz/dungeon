
package dungenModel;


public class Items implements java.io.Serializable {
    
    private String navn;
    private String discription;

    public Items(String navn, String discription) {
        
        this.navn = navn;
        this.discription = discription;
    }

    public String getNavn() {
        return navn;
    }

    public String getDiscription() {
        return discription;
    }

    @Override
    public String toString() {
        return "navn: " + navn + "\ndiscription: " + discription +"\n" ;
    }
    
}
