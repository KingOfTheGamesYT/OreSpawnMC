/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderSquidZooka
/*     */   implements IItemRenderer
/*     */ {
/*  15 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "SquidZookatexture.png");
/*     */ 
/*     */ 
/*     */   
/*  19 */   protected ModelSquidZooka modelSquidZooka = new ModelSquidZooka();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  26 */     switch (type) {
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*  30 */         return true;
/*     */       
/*     */       case EQUIPPED_FIRST_PERSON:
/*  33 */         return true;
/*     */     } 
/*  35 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*  51 */     switch (type) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*  57 */         renderSwordF5(2.0F, 8.0F, 2.0F, 0.35F);
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case EQUIPPED_FIRST_PERSON:
/*  63 */         renderSword(4.0F, 2.0F, 2.0F, 0.35F);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderSword(float x, float y, float z, float scale) {
/*  76 */     GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */     
/*  80 */     GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/*  82 */     GL11.glScalef(scale, scale, scale);
/*  83 */     GL11.glTranslatef(x, y, z);
/*     */ 
/*     */     
/*  86 */     (FMLClientHandler.instance().getClient()).renderEngine.bindTexture(texture);
/*  87 */     this.modelSquidZooka.render();
/*     */     
/*  89 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderSwordF5(float x, float y, float z, float scale) {
/*  98 */     GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */     
/* 102 */     GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
/* 103 */     GL11.glScalef(scale, scale, scale);
/* 104 */     GL11.glTranslatef(x, y, z);
/*     */ 
/*     */     
/* 107 */     (FMLClientHandler.instance().getClient()).renderEngine.bindTexture(texture);
/* 108 */     this.modelSquidZooka.render();
/*     */     
/* 110 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderSquidZooka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */