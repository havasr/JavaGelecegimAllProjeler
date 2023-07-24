import service.LoadService;

public class Main {
    public static void main(String[] args) {

        LoadService loadService = new LoadService();

        System.out.println(loadService.loadCharacters());
        System.out.println(loadService.loadPokemons());


    }
}