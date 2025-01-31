package lupici.ofa;

// Basic forge stuff
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
// Basic java stuff for fetching data from API
import java.util.Map;
// Mod Classes
import lupici.ofa.proxy.ClientProxy;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {

    // Mod stuff
    public static final String MODID = "OFA";
    public static final String NAME = "OFA Mod";
    public static final String VERSION = "0.1.0";

    @SidedProxy(clientSide = "lupici.ofa.proxy.ClientProxy") // Setup my client proxy
    public static ClientProxy clientProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventHandler()); // Register EventHandler class

        clientProxy.preInit(event); // preInit in client proxy (keybindings)
    }

    // public static boolean onSkyblock;
    public static Map<String, Product> productMap;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) { // Event Handler, initialization event
        productMap = Bazaar.fetchProducts();
    }

    /* public void printToJSON(JsonObject products) {
        String jsonProducts = new Gson().toJson(products);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output2.json"));
            writer.write(jsonProducts);
            System.out.println("JSON content has been written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing JSON to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the BufferedWriter: " + e.getMessage());
            }
        }

    } */ // Print to JSON function


}
