package lupici.ofa.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy {
    public static KeyBinding modKeyBinding;

    public void registerKeyBindings() {
        modKeyBinding = new KeyBinding("OFA", Keyboard.KEY_O, "key.categories.mod");
        ClientRegistry.registerKeyBinding(modKeyBinding);
    }

    public void preInit(FMLPreInitializationEvent event) {
        registerKeyBindings();
    } // Just registering key bindings :)

}
