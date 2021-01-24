/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Alien;
/*    */ import danger.orespawn.entity.model.ModelAlien;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderAlien
/*    */   extends RenderLiving<Alien>
/*    */ {
/*    */   protected ModelAlien model;
/* 21 */   private float scale = 1.0F;
/* 22 */   private static final ResourceLocation texture = new ResourceLocation("orespawn", "MyAlien.png");
/*    */   
/*    */   public RenderAlien(RenderManager manager, ModelAlien par1ModelBase, float par2, float par3) {
/* 25 */     super(manager, (ModelBase)par1ModelBase, par2 * par3);
/* 26 */     this.model = (ModelAlien)this.mainModel;
/* 27 */     this.scale = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAlien(Alien par1EntityAlien, double par2, double par4, double par6, float par8, float par9) {
/* 33 */     doRender((EntityLiving)par1EntityAlien, par2, par4, par6, par8, par9);
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(Alien par1Entity, float par2) {
/* 57 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
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
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Alien entity) {
/* 77 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\render\RenderAlien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */