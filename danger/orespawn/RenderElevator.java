/*    */ package danger.orespawn;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderElevator
/*    */   extends Render
/*    */ {
/* 22 */   protected ModelBase modelElevator = new ModelElevator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderElevator(Elevator par1EntityElevator, double par2, double par4, double par6, float par8, float par9) {
/* 30 */     GL11.glPushMatrix();
/* 31 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 32 */     GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
/* 33 */     float f2 = par1EntityElevator.getTimeSinceHit() - par9;
/* 34 */     float f3 = par1EntityElevator.getDamageTaken() - par9;
/*    */     
/* 36 */     if (f3 < 0.0F)
/*    */     {
/* 38 */       f3 = 0.0F;
/*    */     }
/*    */     
/* 41 */     if (f2 > 0.0F)
/*    */     {
/* 43 */       GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * par1EntityElevator.getForwardDirection(), 1.0F, 0.0F, 0.0F);
/*    */     }
/*    */     
/* 46 */     float f4 = 0.75F;
/* 47 */     GL11.glScalef(f4, f4, f4);
/* 48 */     GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
/* 49 */     bindTexture(par1EntityElevator.getTexture());
/* 50 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/* 51 */     this.modelElevator.render((Entity)par1EntityElevator, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/* 52 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 63 */     renderElevator((Elevator)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 68 */     Elevator a = (Elevator)entity;
/* 69 */     return a.getTexture();
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderElevator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */