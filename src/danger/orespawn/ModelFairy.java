/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelFairy
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer head;
/*     */   ModelRenderer chest;
/*     */   ModelRenderer waist;
/*     */   ModelRenderer hips;
/*     */   ModelRenderer lleg1;
/*     */   ModelRenderer lleg2;
/*     */   ModelRenderer rleg;
/*     */   ModelRenderer b1;
/*     */   ModelRenderer b2;
/*     */   ModelRenderer larm;
/*     */   ModelRenderer rarm;
/*     */   ModelRenderer lwing2;
/*     */   ModelRenderer lwing1;
/*     */   ModelRenderer rwing2;
/*     */   ModelRenderer rwing1;
/*     */   
/*     */   public ModelFairy(float f1) {
/*  33 */     this.wingspeed = f1;
/*  34 */     this.textureWidth = 64;
/*  35 */     this.textureHeight = 64;
/*     */     
/*  37 */     this.head = new ModelRenderer(this, 0, 0);
/*  38 */     this.head.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5);
/*  39 */     this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  40 */     this.head.setTextureSize(64, 64);
/*  41 */     this.head.mirror = true;
/*  42 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  43 */     this.chest = new ModelRenderer(this, 31, 5);
/*  44 */     this.chest.addBox(-3.5F, 0.0F, -1.0F, 7, 4, 3);
/*  45 */     this.chest.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  46 */     this.chest.setTextureSize(64, 64);
/*  47 */     this.chest.mirror = true;
/*  48 */     setRotation(this.chest, 0.0F, 0.0F, 0.0F);
/*  49 */     this.waist = new ModelRenderer(this, 33, 13);
/*  50 */     this.waist.addBox(-2.5F, 4.0F, -1.0F, 5, 3, 3);
/*  51 */     this.waist.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  52 */     this.waist.setTextureSize(64, 64);
/*  53 */     this.waist.mirror = true;
/*  54 */     setRotation(this.waist, 0.0F, 0.0F, 0.0F);
/*  55 */     this.hips = new ModelRenderer(this, 31, 20);
/*  56 */     this.hips.addBox(-3.0F, 7.0F, -1.0F, 6, 4, 4);
/*  57 */     this.hips.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  58 */     this.hips.setTextureSize(64, 64);
/*  59 */     this.hips.mirror = true;
/*  60 */     setRotation(this.hips, 0.0F, 0.0F, 0.0F);
/*  61 */     this.lleg1 = new ModelRenderer(this, 53, 8);
/*  62 */     this.lleg1.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2);
/*  63 */     this.lleg1.setRotationPoint(1.0F, 10.0F, 0.0F);
/*  64 */     this.lleg1.setTextureSize(64, 64);
/*  65 */     this.lleg1.mirror = true;
/*  66 */     setRotation(this.lleg1, -0.7853982F, 0.0F, 0.0F);
/*  67 */     this.lleg2 = new ModelRenderer(this, 53, 18);
/*  68 */     this.lleg2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
/*  69 */     this.lleg2.setRotationPoint(1.0F, 15.0F, -5.0F);
/*  70 */     this.lleg2.setTextureSize(64, 64);
/*  71 */     this.lleg2.mirror = true;
/*  72 */     setRotation(this.lleg2, 0.7679449F, 0.0F, 0.0F);
/*  73 */     this.rleg = new ModelRenderer(this, 51, 30);
/*  74 */     this.rleg.addBox(-3.0F, 0.0F, 0.0F, 2, 13, 2);
/*  75 */     this.rleg.setRotationPoint(0.0F, 11.0F, 0.0F);
/*  76 */     this.rleg.setTextureSize(64, 64);
/*  77 */     this.rleg.mirror = true;
/*  78 */     setRotation(this.rleg, 0.0F, 0.0F, 0.0F);
/*  79 */     this.b1 = new ModelRenderer(this, 42, 1);
/*  80 */     this.b1.addBox(1.0F, 1.0F, -2.0F, 2, 2, 1);
/*  81 */     this.b1.setRotationPoint(0.0F, 1.0F, 0.0F);
/*  82 */     this.b1.setTextureSize(64, 64);
/*  83 */     this.b1.mirror = true;
/*  84 */     setRotation(this.b1, 0.0F, 0.0F, 0.0F);
/*  85 */     this.b2 = new ModelRenderer(this, 32, 1);
/*  86 */     this.b2.addBox(-3.0F, 2.0F, -2.0F, 2, 2, 1);
/*  87 */     this.b2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  88 */     this.b2.setTextureSize(64, 64);
/*  89 */     this.b2.mirror = true;
/*  90 */     setRotation(this.b2, 0.0F, 0.0F, 0.0F);
/*  91 */     this.larm = new ModelRenderer(this, 7, 14);
/*  92 */     this.larm.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1);
/*  93 */     this.larm.setRotationPoint(3.0F, 0.0F, 0.0F);
/*  94 */     this.larm.setTextureSize(64, 64);
/*  95 */     this.larm.mirror = true;
/*  96 */     setRotation(this.larm, -0.0174533F, 0.0F, -0.122173F);
/*  97 */     this.rarm = new ModelRenderer(this, 2, 14);
/*  98 */     this.rarm.addBox(-1.0F, 0.0F, 0.0F, 1, 10, 1);
/*  99 */     this.rarm.setRotationPoint(-3.0F, 0.0F, 0.0F);
/* 100 */     this.rarm.setTextureSize(64, 64);
/* 101 */     this.rarm.mirror = true;
/* 102 */     setRotation(this.rarm, -0.0174533F, 0.0F, 0.122173F);
/* 103 */     this.lwing2 = new ModelRenderer(this, 0, 47);
/* 104 */     this.lwing2.addBox(0.0F, -9.0F, 0.0F, 26, 16, 0);
/* 105 */     this.lwing2.setRotationPoint(2.0F, 0.0F, 2.0F);
/* 106 */     this.lwing2.setTextureSize(64, 64);
/* 107 */     this.lwing2.mirror = true;
/* 108 */     setRotation(this.lwing2, 0.0F, -0.5934119F, 0.0F);
/* 109 */     this.lwing1 = new ModelRenderer(this, 0, 30);
/* 110 */     this.lwing1.addBox(0.0F, -7.0F, 0.0F, 24, 16, 0);
/* 111 */     this.lwing1.setRotationPoint(2.0F, 3.0F, 2.0F);
/* 112 */     this.lwing1.setTextureSize(64, 64);
/* 113 */     this.lwing1.mirror = true;
/* 114 */     setRotation(this.lwing1, 0.0F, -0.8203047F, 0.0F);
/* 115 */     this.rwing2 = new ModelRenderer(this, 0, 30);
/* 116 */     this.rwing2.addBox(0.0F, -7.0F, 0.0F, 24, 16, 0);
/* 117 */     this.rwing2.setRotationPoint(-2.0F, 3.0F, 2.0F);
/* 118 */     this.rwing2.setTextureSize(64, 64);
/* 119 */     this.rwing2.mirror = true;
/* 120 */     setRotation(this.rwing2, 0.0F, -2.356194F, 0.0F);
/* 121 */     this.rwing1 = new ModelRenderer(this, 0, 47);
/* 122 */     this.rwing1.addBox(0.0F, -9.0F, 0.0F, 26, 16, 0);
/* 123 */     this.rwing1.setRotationPoint(-2.0F, 0.0F, 2.0F);
/* 124 */     this.rwing1.setTextureSize(64, 64);
/* 125 */     this.rwing1.mirror = true;
/* 126 */     setRotation(this.rwing1, 0.0F, -2.548181F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 132 */     Fairy fly = (Fairy)entity;
/* 133 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 134 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 135 */     float onoff = 0.0F;
/*     */ 
/*     */     
/* 138 */     this.lwing1.rotateAngleY = -0.6F + MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.35F;
/* 139 */     this.rwing1.rotateAngleY = -2.55F - MathHelper.cos(f2 * this.wingspeed) * 3.1415927F * 0.35F;
/* 140 */     this.lwing2.rotateAngleY = -0.6F + MathHelper.cos(f2 * this.wingspeed * 0.85F) * 3.1415927F * 0.25F;
/* 141 */     this.rwing2.rotateAngleY = -2.55F - MathHelper.cos(f2 * this.wingspeed * 0.85F) * 3.1415927F * 0.25F;
/*     */     
/* 143 */     this.head.rotateAngleY = (float)Math.toRadians(f3) * 0.45F;
/* 144 */     if (this.head.rotateAngleY > 0.45F) this.head.rotateAngleY = 0.45F; 
/* 145 */     if (this.head.rotateAngleY < -0.45F) this.head.rotateAngleY = -0.45F; 
/* 146 */     this.head.rotateAngleX = (float)Math.toRadians(f4);
/*     */     
/* 148 */     this.larm.rotateAngleX = -0.2F + MathHelper.cos(f2 * this.wingspeed * 0.15F) * 3.1415927F * 0.05F;
/* 149 */     this.rarm.rotateAngleX = -0.2F + MathHelper.cos(f2 * this.wingspeed * 0.12F) * 3.1415927F * 0.05F;
/* 150 */     this.larm.rotateAngleZ = -0.15F + MathHelper.cos(f2 * this.wingspeed * 0.1F) * 3.1415927F * 0.03F;
/* 151 */     this.rarm.rotateAngleZ = 0.15F + MathHelper.cos(f2 * this.wingspeed * 0.11F) * 3.1415927F * 0.03F;
/*     */     
/* 153 */     this.lwing2.render(f5);
/* 154 */     this.lwing1.render(f5);
/* 155 */     this.rwing2.render(f5);
/* 156 */     this.rwing1.render(f5);
/*     */     
/* 158 */     onoff = fly.getBlink();
/* 159 */     OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, onoff, 240.0F);
/* 160 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 161 */     this.head.render(f5);
/* 162 */     this.chest.render(f5);
/* 163 */     this.waist.render(f5);
/* 164 */     this.hips.render(f5);
/* 165 */     this.lleg1.render(f5);
/* 166 */     this.lleg2.render(f5);
/* 167 */     this.rleg.render(f5);
/* 168 */     this.b1.render(f5);
/* 169 */     this.b2.render(f5);
/* 170 */     this.larm.render(f5);
/* 171 */     this.rarm.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 177 */     model.rotateAngleX = x;
/* 178 */     model.rotateAngleY = y;
/* 179 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 184 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelFairy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */