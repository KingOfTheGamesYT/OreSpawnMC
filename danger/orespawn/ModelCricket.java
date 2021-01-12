/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCricket
/*     */   extends ModelBase
/*     */ {
/*  11 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer body;
/*     */   
/*     */   ModelRenderer head;
/*     */   
/*     */   ModelRenderer abdomen;
/*     */   ModelRenderer lfleg;
/*     */   ModelRenderer lrleg;
/*     */   ModelRenderer rfleg;
/*     */   ModelRenderer rrleg;
/*     */   ModelRenderer lleg1;
/*     */   ModelRenderer rleg1;
/*     */   ModelRenderer lleg2;
/*     */   ModelRenderer rleg2;
/*     */   
/*     */   public ModelCricket(float f1) {
/*  28 */     this.wingspeed = f1;
/*     */     
/*  30 */     this.textureWidth = 64;
/*  31 */     this.textureHeight = 64;
/*     */     
/*  33 */     this.body = new ModelRenderer(this, 0, 25);
/*  34 */     this.body.addBox(-1.0F, -1.0F, -3.0F, 3, 3, 6);
/*  35 */     this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
/*  36 */     this.body.setTextureSize(64, 64);
/*  37 */     this.body.mirror = true;
/*  38 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  39 */     this.head = new ModelRenderer(this, 0, 17);
/*  40 */     this.head.addBox(-1.0F, -2.0F, -1.0F, 3, 4, 3);
/*  41 */     this.head.setRotationPoint(0.0F, 21.0F, -5.0F);
/*  42 */     this.head.setTextureSize(64, 64);
/*  43 */     this.head.mirror = true;
/*  44 */     setRotation(this.head, -0.1745329F, 0.0F, 0.0F);
/*  45 */     this.abdomen = new ModelRenderer(this, 0, 36);
/*  46 */     this.abdomen.addBox(-0.5F, -1.0F, 3.0F, 2, 2, 3);
/*  47 */     this.abdomen.setRotationPoint(0.0F, 21.0F, 0.0F);
/*  48 */     this.abdomen.setTextureSize(64, 64);
/*  49 */     this.abdomen.mirror = true;
/*  50 */     setRotation(this.abdomen, 0.0F, 0.0F, 0.0F);
/*  51 */     this.lfleg = new ModelRenderer(this, 25, 0);
/*  52 */     this.lfleg.addBox(2.0F, 0.0F, 0.0F, 5, 1, 1);
/*  53 */     this.lfleg.setRotationPoint(0.0F, 21.0F, -2.0F);
/*  54 */     this.lfleg.setTextureSize(64, 64);
/*  55 */     this.lfleg.mirror = true;
/*  56 */     setRotation(this.lfleg, 0.0F, 0.4712389F, 0.418879F);
/*  57 */     this.lrleg = new ModelRenderer(this, 23, 4);
/*  58 */     this.lrleg.addBox(1.0F, 0.0F, -2.0F, 6, 1, 1);
/*  59 */     this.lrleg.setRotationPoint(0.0F, 21.0F, 0.0F);
/*  60 */     this.lrleg.setTextureSize(64, 64);
/*  61 */     this.lrleg.mirror = true;
/*  62 */     setRotation(this.lrleg, 0.0F, -0.296706F, 0.418879F);
/*  63 */     this.rfleg = new ModelRenderer(this, 25, 8);
/*  64 */     this.rfleg.addBox(-7.0F, 0.0F, 0.0F, 5, 1, 1);
/*  65 */     this.rfleg.setRotationPoint(1.0F, 21.0F, -2.0F);
/*  66 */     this.rfleg.setTextureSize(64, 64);
/*  67 */     this.rfleg.mirror = true;
/*  68 */     setRotation(this.rfleg, 0.0F, -0.5410521F, -0.4363323F);
/*  69 */     this.rrleg = new ModelRenderer(this, 25, 12);
/*  70 */     this.rrleg.addBox(-7.0F, -1.0F, 0.0F, 5, 1, 1);
/*  71 */     this.rrleg.setRotationPoint(1.0F, 22.0F, -2.0F);
/*  72 */     this.rrleg.setTextureSize(64, 64);
/*  73 */     this.rrleg.mirror = true;
/*  74 */     setRotation(this.rrleg, 0.0F, 0.3839724F, -0.418879F);
/*  75 */     this.lleg1 = new ModelRenderer(this, 40, 0);
/*  76 */     this.lleg1.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 8);
/*  77 */     this.lleg1.setRotationPoint(2.0F, 22.0F, 0.0F);
/*  78 */     this.lleg1.setTextureSize(64, 64);
/*  79 */     this.lleg1.mirror = true;
/*  80 */     setRotation(this.lleg1, 0.5585054F, 0.4363323F, 0.0F);
/*  81 */     this.rleg1 = new ModelRenderer(this, 40, 11);
/*  82 */     this.rleg1.addBox(0.0F, -1.0F, 0.0F, 1, 2, 8);
/*  83 */     this.rleg1.setRotationPoint(-1.0F, 22.0F, 0.0F);
/*  84 */     this.rleg1.setTextureSize(64, 64);
/*  85 */     this.rleg1.mirror = true;
/*  86 */     setRotation(this.rleg1, 0.5585054F, -0.4363323F, 0.0F);
/*  87 */     this.lleg2 = new ModelRenderer(this, 21, 23);
/*  88 */     this.lleg2.addBox(-0.5F, -6.5F, 4.5F, 1, 1, 8);
/*  89 */     this.lleg2.setRotationPoint(2.0F, 22.0F, 0.0F);
/*  90 */     this.lleg2.setTextureSize(64, 64);
/*  91 */     this.lleg2.mirror = true;
/*  92 */     setRotation(this.lleg2, -0.3665191F, 0.3490659F, 0.0F);
/*  93 */     this.rleg2 = new ModelRenderer(this, 21, 34);
/*  94 */     this.rleg2.addBox(-0.5F, -6.5F, 4.0F, 1, 1, 8);
/*  95 */     this.rleg2.setRotationPoint(-1.0F, 22.0F, 0.0F);
/*  96 */     this.rleg2.setTextureSize(64, 64);
/*  97 */     this.rleg2.mirror = true;
/*  98 */     setRotation(this.rleg2, -0.3665191F, -0.3490659F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 104 */     Cricket c = (Cricket)entity;
/* 105 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 106 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 107 */     float newangle = 0.0F;
/*     */     
/* 109 */     if (f1 > 0.1D) {
/* 110 */       newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 112 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 115 */     this.lfleg.rotateAngleY = 0.47F + newangle;
/* 116 */     this.rfleg.rotateAngleY = -0.54F + newangle;
/* 117 */     this.lrleg.rotateAngleY = -0.296F - newangle;
/* 118 */     this.rrleg.rotateAngleY = 0.384F - newangle;
/*     */     
/* 120 */     if (c.getSinging() != 0) {
/* 121 */       newangle = MathHelper.cos(f2 * 3.0F * this.wingspeed) * 3.1415927F * 0.25F;
/* 122 */       this.lleg1.rotateAngleY = -0.035F;
/* 123 */       this.lleg2.rotateAngleY = -0.105F;
/* 124 */       this.rleg1.rotateAngleY = 0.035F;
/* 125 */       this.rleg2.rotateAngleY = 0.105F;
/*     */     } else {
/* 127 */       newangle = 0.0F;
/* 128 */       this.lleg1.rotateAngleY = 0.436F;
/* 129 */       this.lleg2.rotateAngleY = 0.349F;
/* 130 */       this.rleg1.rotateAngleY = -0.436F;
/* 131 */       this.rleg2.rotateAngleY = -0.349F;
/*     */     } 
/* 133 */     this.lleg1.rotateAngleX = newangle + 0.558F;
/* 134 */     this.lleg2.rotateAngleX = newangle - 0.366F;
/* 135 */     this.rleg1.rotateAngleX = -newangle + 0.558F;
/* 136 */     this.rleg2.rotateAngleX = -newangle - 0.366F;
/*     */     
/* 138 */     this.body.render(f5);
/* 139 */     this.head.render(f5);
/* 140 */     this.abdomen.render(f5);
/* 141 */     this.lfleg.render(f5);
/* 142 */     this.lrleg.render(f5);
/* 143 */     this.rfleg.render(f5);
/* 144 */     this.rrleg.render(f5);
/* 145 */     this.lleg1.render(f5);
/* 146 */     this.rleg1.render(f5);
/* 147 */     this.lleg2.render(f5);
/* 148 */     this.rleg2.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 154 */     model.rotateAngleX = x;
/* 155 */     model.rotateAngleY = y;
/* 156 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 161 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCricket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */