/*    */ package danger.orespawn;
/*    */ 
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class RenderRockBase
/*    */   extends RenderLiving
/*    */ {
/*    */   protected ModelRockBase model;
/* 15 */   private float scale = 1.0F;
/* 16 */   private static final ResourceLocation texture1 = new ResourceLocation("orespawn", "Rocktexture.png");
/* 17 */   private static final ResourceLocation texture2 = new ResourceLocation("orespawn", "Rocktexture.png");
/* 18 */   private static final ResourceLocation texture3 = new ResourceLocation("orespawn", "RockRedtexture.png");
/* 19 */   private static final ResourceLocation texture4 = new ResourceLocation("orespawn", "RockGreentexture.png");
/* 20 */   private static final ResourceLocation texture5 = new ResourceLocation("orespawn", "RockBluetexture.png");
/* 21 */   private static final ResourceLocation texture6 = new ResourceLocation("orespawn", "RockPurpletexture.png");
/* 22 */   private static final ResourceLocation texture7 = new ResourceLocation("orespawn", "Rocktexture.png");
/* 23 */   private static final ResourceLocation texture8 = new ResourceLocation("orespawn", "RockTNTtexture.png");
/* 24 */   private static final ResourceLocation texture9 = new ResourceLocation("orespawn", "rockcrystaltexture.png");
/* 25 */   private static final ResourceLocation texture10 = new ResourceLocation("orespawn", "rockcrystalgreentexture.png");
/* 26 */   private static final ResourceLocation texture11 = new ResourceLocation("orespawn", "rockcrystalbluetexture.png");
/* 27 */   private static final ResourceLocation texture12 = new ResourceLocation("orespawn", "rockcrystaltnttexture.png");
/*    */   
/*    */   public RenderRockBase(ModelRockBase par1ModelBase, float par2, float par3) {
/* 30 */     super(par1ModelBase, par2 * par3);
/* 31 */     this.model = (ModelRockBase)this.mainModel;
/* 32 */     this.scale = par3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderRockBase(RockBase par1EntityRockBase, double par2, double par4, double par6, float par8, float par9) {
/* 38 */     super.doRender(par1EntityRockBase, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 43 */     renderRockBase((RockBase)par1EntityLiving, par2, par4, par6, par8, par9);
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
/* 54 */     renderRockBase((RockBase)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(RockBase par1Entity, float par2) {
/* 62 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
/* 71 */     preRenderScale((RockBase)par1EntityLiving, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity entity) {
/* 77 */     RockBase r = (RockBase)entity;
/* 78 */     int i = r.getRockType();
/* 79 */     if (i == 1) return texture1; 
/* 80 */     if (i == 2) return texture2; 
/* 81 */     if (i == 3) return texture3; 
/* 82 */     if (i == 4) return texture4; 
/* 83 */     if (i == 5) return texture5; 
/* 84 */     if (i == 6) return texture6; 
/* 85 */     if (i == 7) return texture7; 
/* 86 */     if (i == 8) return texture8; 
/* 87 */     if (i == 9) return texture9; 
/* 88 */     if (i == 10) return texture10; 
/* 89 */     if (i == 11) return texture11; 
/* 90 */     if (i == 12) return texture12; 
/* 91 */     return texture1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\RenderRockBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */