package lupici.ofa;

import lupici.ofa.gui.GUI;
import lupici.ofa.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static lupici.ofa.Main.productMap;

public class EventHandler {

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().inGameHasFocus) {
            if (ClientProxy.modKeyBinding.isPressed()) {
                productMap = Bazaar.fetchProducts();

                Minecraft.getMinecraft().displayGuiScreen(new GUI());

            }

        }

    }


}
