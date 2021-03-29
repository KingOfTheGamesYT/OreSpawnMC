/*    */ package danger.orespawn.entity.render;
/*    */ 
/*    */ import danger.orespawn.entity.Moth;
/*    */ import danger.orespawn.entity.model.ModelButterfly;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class RenderMoth
/*    */   extends RenderLiving<Moth> {
/* 14 */   ResourceLocation TEXTURE1 = new ResourceLocation("orespawn:textures/entity/lunamoth.png");
/* 15 */   ResourceLocation TEXTURE2 = new ResourceLocation("orespawn:textures/entity/eyemoth.png");
/* 16 */   ResourceLocation TEXTURE3 = new ResourceLocation("orespawn:textures/entity/firemoth.png");
/* 17 */   ResourceLocation TEXTURE4 = new ResourceLocation("orespawn:textures/entity/darkmoth.png");
/*    */   protected ModelButterfly model;
/* 19 */   private float scale = 1.0F;
/*    */ 
/*    */   
/*    */   public RenderMoth(RenderManager manager) {
/* 23 */     super(manager, (ModelBase)new ModelButterfly(0.6F, 1.5F), 0.0F);
/* 24 */     this.model = (ModelButterfly)this.mainModel;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   protected ResourceLocation getEntityTexture(Moth entity) {
/* 30 */     switch (entity.moth_type) { case 0:
/* 31 */         return this.TEXTURE1;
/* 32 */       case 1: return this.TEXTURE2;
/* 33 */       case 2: return this.TEXTURE3; }
/* 34 */      return this.TEXTURE4;
/*    */   }
/*    */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\render\RenderMoth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */