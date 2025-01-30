package lupici.ofa.gui;

import net.minecraft.client.gui.GuiScreen;

import static lupici.ofa.Bazaar.profitt;

public class GUI extends GuiScreen {

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        this.drawCenteredString(this.fontRendererObj, "Profit for item: " + profitt("GRIFFIN_FEATHER"), this.width / 2, this.height / 2, 0xFFFFF);
    }
}
