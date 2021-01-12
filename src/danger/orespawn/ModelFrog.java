/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelFrog
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer jaw;
/*     */   
/*     */   ModelRenderer lfleg;
/*     */   ModelRenderer rfleg;
/*     */   ModelRenderer lleg1;
/*     */   ModelRenderer rleg1;
/*     */   ModelRenderer lleg2;
/*     */   ModelRenderer rleg2;
/*     */   ModelRenderer leye;
/*     */   ModelRenderer reye;
/*     */   
/*     */   public ModelFrog(float f1) {
/*  27 */     this.wingspeed = f1;
/*     */     
/*  29 */     this.textureWidth = 64;
/*  30 */     this.textureHeight = 64;
/*     */     
/*  32 */     this.body = new ModelRenderer(this, 41, 0);
/*  33 */     this.body.addBox(-4.0F, -10.0F, 0.0F, 8, 11, 2);
/*  34 */     this.body.setRotationPoint(0.0F, 24.0F, 2.0F);
/*  35 */     this.body.setTextureSize(64, 64);
/*  36 */     this.body.mirror = true;
/*  37 */     setRotation(this.body, 0.7330383F, 0.0F, 0.0F);
/*  38 */     this.jaw = new ModelRenderer(this, 42, 15);
/*  39 */     this.jaw.addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1);
/*  40 */     this.jaw.setRotationPoint(0.0F, 24.0F, 2.0F);
/*  41 */     this.jaw.setTextureSize(64, 64);
/*  42 */     this.jaw.mirror = true;
/*  43 */     setRotation(this.jaw, 1.22173F, 0.0F, 0.0F);
/*  44 */     this.lfleg = new ModelRenderer(this, 14, 0);
/*  45 */     this.lfleg.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
/*  46 */     this.lfleg.setRotationPoint(3.0F, 20.0F, 0.0F);
/*  47 */     this.lfleg.setTextureSize(64, 64);
/*  48 */     this.lfleg.mirror = true;
/*  49 */     setRotation(this.lfleg, -0.5235988F, 0.0F, -0.4712389F);
/*  50 */     this.rfleg = new ModelRenderer(this, 20, 0);
/*  51 */     this.rfleg.addBox(-1.0F, 0.0F, 0.0F, 1, 5, 1);
/*  52 */     this.rfleg.setRotationPoint(-3.0F, 20.0F, 0.0F);
/*  53 */     this.rfleg.setTextureSize(64, 64);
/*  54 */     this.rfleg.mirror = true;
/*  55 */     setRotation(this.rfleg, -0.5235988F, 0.0F, 0.4712389F);
/*  56 */     this.lleg1 = new ModelRenderer(this, 10, 8);
/*  57 */     this.lleg1.addBox(0.0F, -9.0F, -1.0F, 1, 9, 2);
/*  58 */     this.lleg1.setRotationPoint(3.0F, 24.0F, 3.0F);
/*  59 */     this.lleg1.setTextureSize(64, 64);
/*  60 */     this.lleg1.mirror = true;
/*  61 */     setRotation(this.lleg1, 0.0F, 0.0F, 0.2268928F);
/*  62 */     this.rleg1 = new ModelRenderer(this, 18, 8);
/*  63 */     this.rleg1.addBox(-1.0F, -9.0F, -1.0F, 1, 9, 2);
/*  64 */     this.rleg1.setRotationPoint(-3.0F, 24.0F, 3.0F);
/*  65 */     this.rleg1.setTextureSize(64, 64);
/*  66 */     this.rleg1.mirror = true;
/*  67 */     setRotation(this.rleg1, 0.0F, 0.0F, -0.2268928F);
/*  68 */     this.lleg2 = new ModelRenderer(this, 11, 20);
/*  69 */     this.lleg2.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
/*  70 */     this.lleg2.setRotationPoint(5.0F, 15.0F, 3.0F);
/*  71 */     this.lleg2.setTextureSize(64, 64);
/*  72 */     this.lleg2.mirror = true;
/*  73 */     setRotation(this.lleg2, 0.0F, 0.0F, -0.3839724F);
/*  74 */     this.rleg2 = new ModelRenderer(this, 19, 20);
/*  75 */     this.rleg2.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1);
/*  76 */     this.rleg2.setRotationPoint(-5.0F, 15.0F, 3.0F);
/*  77 */     this.rleg2.setTextureSize(64, 64);
/*  78 */     this.rleg2.mirror = true;
/*  79 */     setRotation(this.rleg2, 0.0F, 0.0F, 0.3839724F);
/*  80 */     this.leye = new ModelRenderer(this, 0, 8);
/*  81 */     this.leye.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/*  82 */     this.leye.setRotationPoint(2.0F, 17.0F, -2.0F);
/*  83 */     this.leye.setTextureSize(64, 64);
/*  84 */     this.leye.mirror = true;
/*  85 */     setRotation(this.leye, 0.7330383F, 0.0F, 0.0F);
/*  86 */     this.reye = new ModelRenderer(this, 0, 4);
/*  87 */     this.reye.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/*  88 */     this.reye.setRotationPoint(-3.0F, 17.0F, -2.0F);
/*  89 */     this.reye.setTextureSize(64, 64);
/*  90 */     this.reye.mirror = true;
/*  91 */     setRotation(this.reye, 0.7330383F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  97 */     Frog c = (Frog)entity;
/*  98 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  99 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 100 */     float newangle = 0.0F;
/*     */     
/* 102 */     if (f1 > 0.1D) {
/* 103 */       newangle = MathHelper.cos(f2 * this.wingspeed * 1.4F) * 3.1415927F * 0.55F * f1;
/*     */     } else {
/* 105 */       newangle = 0.0F;
/*     */     } 
/* 107 */     this.lfleg.rotateAngleY = newangle;
/* 108 */     this.rfleg.rotateAngleY = -newangle;
/* 109 */     this.lleg2.rotateAngleY = -newangle / 2.0F;
/* 110 */     this.rleg2.rotateAngleY = newangle / 2.0F;
/*     */ 
/*     */     
/* 113 */     if (c.getSinging() != 0) {
/* 114 */       newangle = MathHelper.cos(f2 * 0.85F * this.wingspeed) * 3.1415927F * 0.15F;
/*     */     } else {
/* 116 */       newangle = 0.0F;
/*     */     } 
/* 118 */     this.jaw.rotateAngleX = newangle + 1.22F;
/*     */     
/* 120 */     if (c.motionY > 0.10000000149011612D || c.motionY < -0.10000000149011612D) {
/* 121 */       this.lleg1.rotateAngleZ = 2.44F;
/* 122 */       this.rleg1.rotateAngleZ = -2.44F;
/*     */     } else {
/* 124 */       this.lleg1.rotateAngleZ = 0.227F;
/* 125 */       this.rleg1.rotateAngleZ = -0.227F;
/*     */     } 
/* 127 */     this.lleg1.rotationPointY -= (float)Math.cos(this.lleg1.rotateAngleZ) * 9.0F;
/* 128 */     this.lleg1.rotationPointX += (float)Math.sin(this.lleg1.rotateAngleZ) * 9.0F;
/*     */     
/* 130 */     this.rleg1.rotationPointY -= (float)Math.cos(this.rleg1.rotateAngleZ) * 9.0F;
/* 131 */     this.rleg1.rotationPointX += (float)Math.sin(this.rleg1.rotateAngleZ) * 9.0F;
/*     */     
/* 133 */     this.body.render(f5);
/* 134 */     this.jaw.render(f5);
/* 135 */     this.lfleg.render(f5);
/* 136 */     this.rfleg.render(f5);
/* 137 */     this.lleg1.render(f5);
/* 138 */     this.rleg1.render(f5);
/* 139 */     this.lleg2.render(f5);
/* 140 */     this.rleg2.render(f5);
/* 141 */     this.leye.render(f5);
/* 142 */     this.reye.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 148 */     model.rotateAngleX = x;
/* 149 */     model.rotateAngleY = y;
/* 150 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 155 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelFrog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */