/*    */ package danger.orespawn;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemTool;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrystalShovel
/*    */   extends ItemTool
/*    */ {
/* 29 */   public static final Set blocksEffectiveAgainst = Sets.newHashSet((Object[])new Block[] { (Block)Blocks.grass, Blocks.dirt, (Block)Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.farmland, (Block)Blocks.mycelium, OreSpawnMain.CrystalGrass });
/*    */ 
/*    */ 
/*    */   
/*    */   public CrystalShovel(int par1, Item.ToolMaterial par2) {
/* 34 */     super(1.0F, par2, blocksEffectiveAgainst);
/* 35 */     this.maxStackSize = 1;
/* 36 */     setCreativeTab(CreativeTabs.tabTools);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canHarvestBlock(Block par1Block) {
/* 44 */     return (par1Block == Blocks.snow);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void registerIcons(IIconRegister iconRegister) {
/* 50 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\CrystalShovel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */