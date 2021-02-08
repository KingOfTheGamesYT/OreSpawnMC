/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelAnt
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer thorax;
/*     */   ModelRenderer thorax1;
/*     */   ModelRenderer thorax3;
/*     */   ModelRenderer abdomen;
/*     */   ModelRenderer abdomen1;
/*     */   ModelRenderer head;
/*     */   ModelRenderer jawsr;
/*     */   ModelRenderer jawsl;
/*     */   ModelRenderer llegtop1;
/*     */   ModelRenderer llegbot1;
/*     */   ModelRenderer llegtop2;
/*     */   ModelRenderer llegbot2;
/*     */   ModelRenderer llegtop3;
/*     */   ModelRenderer llegbot3;
/*     */   ModelRenderer rlegtop1;
/*     */   ModelRenderer rlegbot1;
/*     */   ModelRenderer rlegtop2;
/*     */   ModelRenderer rlegbot2;
/*     */   ModelRenderer rlegtop3;
/*     */   ModelRenderer rlegbot3;
/*     */   
/*     */   public ModelAnt() {
/*  34 */     this.textureWidth = 64;
/*  35 */     this.textureHeight = 32;
/*  36 */     this.thorax = new ModelRenderer(this, 22, 0);
/*  37 */     this.thorax.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
/*  38 */     this.thorax.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  39 */     this.thorax.setTextureSize(64, 32);
/*  40 */     this.thorax.mirror = true;
/*  41 */     setRotation(this.thorax, 0.0F, 0.0F, 0.0F);
/*  42 */     this.thorax1 = new ModelRenderer(this, 18, 0);
/*  43 */     this.thorax1.addBox(1.0F, 1.0F, -1.0F, 1, 1, 1);
/*  44 */     this.thorax1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  45 */     this.thorax1.setTextureSize(64, 32);
/*  46 */     this.thorax1.mirror = true;
/*  47 */     setRotation(this.thorax1, 0.0F, 0.0F, 0.0F);
/*  48 */     this.thorax3 = new ModelRenderer(this, 34, 0);
/*  49 */     this.thorax3.addBox(1.0F, 1.0F, 3.0F, 1, 1, 1);
/*  50 */     this.thorax3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  51 */     this.thorax3.setTextureSize(64, 32);
/*  52 */     this.thorax3.mirror = true;
/*  53 */     setRotation(this.thorax3, 0.0F, 0.0F, 0.0F);
/*  54 */     this.abdomen = new ModelRenderer(this, 38, 0);
/*  55 */     this.abdomen.addBox(0.0F, 0.0F, 4.0F, 3, 3, 5);
/*  56 */     this.abdomen.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  57 */     this.abdomen.setTextureSize(64, 32);
/*  58 */     this.abdomen.mirror = true;
/*  59 */     setRotation(this.abdomen, 0.0F, 0.0F, 0.0F);
/*  60 */     this.abdomen1 = new ModelRenderer(this, 54, 0);
/*  61 */     this.abdomen1.addBox(1.0F, 1.0F, 9.0F, 1, 1, 1);
/*  62 */     this.abdomen1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  63 */     this.abdomen1.setTextureSize(64, 32);
/*  64 */     this.abdomen1.mirror = true;
/*  65 */     setRotation(this.abdomen1, 0.0F, 0.0F, 0.0F);
/*  66 */     this.head = new ModelRenderer(this, 6, 0);
/*  67 */     this.head.addBox(0.0F, -1.0F, -4.0F, 3, 3, 3);
/*  68 */     this.head.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  69 */     this.head.setTextureSize(64, 32);
/*  70 */     this.head.mirror = true;
/*  71 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  72 */     this.jawsr = new ModelRenderer(this, 0, 9);
/*  73 */     this.jawsr.addBox(-1.0F, 0.0F, -6.0F, 1, 1, 3);
/*  74 */     this.jawsr.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  75 */     this.jawsr.setTextureSize(64, 32);
/*  76 */     this.jawsr.mirror = true;
/*  77 */     setRotation(this.jawsr, 0.0F, 0.0F, 0.0F);
/*  78 */     this.jawsl = new ModelRenderer(this, 0, 14);
/*  79 */     this.jawsl.addBox(3.0F, 0.0F, -6.0F, 1, 1, 3);
/*  80 */     this.jawsl.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  81 */     this.jawsl.setTextureSize(64, 32);
/*  82 */     this.jawsl.mirror = true;
/*  83 */     setRotation(this.jawsl, 0.0F, 0.0F, 0.0F);
/*  84 */     this.llegtop1 = new ModelRenderer(this, 15, 10);
/*  85 */     this.llegtop1.addBox(3.0F, 1.0F, 1.0F, 3, 1, 1);
/*  86 */     this.llegtop1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  87 */     this.llegtop1.setTextureSize(64, 32);
/*  88 */     this.llegtop1.mirror = true;
/*  89 */     setRotation(this.llegtop1, 0.0F, 0.0F, 0.3839724F);
/*  90 */     this.llegbot1 = new ModelRenderer(this, 15, 19);
/*  91 */     this.llegbot1.addBox(5.0F, -3.0F, 1.0F, 3, 1, 1);
/*  92 */     this.llegbot1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  93 */     this.llegbot1.setTextureSize(64, 32);
/*  94 */     this.llegbot1.mirror = true;
/*  95 */     setRotation(this.llegbot1, 0.0F, 0.0F, 1.064651F);
/*  96 */     this.llegtop2 = new ModelRenderer(this, 15, 13);
/*  97 */     this.llegtop2.addBox(3.0F, 1.0F, 2.0F, 3, 1, 1);
/*  98 */     this.llegtop2.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  99 */     this.llegtop2.setTextureSize(64, 32);
/* 100 */     this.llegtop2.mirror = true;
/* 101 */     setRotation(this.llegtop2, 0.0F, -0.2094395F, 0.3839724F);
/* 102 */     this.llegbot2 = new ModelRenderer(this, 15, 22);
/* 103 */     this.llegbot2.addBox(5.0F, -3.0F, 2.0F, 3, 1, 1);
/* 104 */     this.llegbot2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 105 */     this.llegbot2.setTextureSize(64, 32);
/* 106 */     this.llegbot2.mirror = true;
/* 107 */     setRotation(this.llegbot2, 0.0F, -0.2268928F, 1.064651F);
/* 108 */     this.llegtop3 = new ModelRenderer(this, 15, 16);
/* 109 */     this.llegtop3.addBox(3.0F, 1.0F, 0.0F, 3, 1, 1);
/* 110 */     this.llegtop3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 111 */     this.llegtop3.setTextureSize(64, 32);
/* 112 */     this.llegtop3.mirror = true;
/* 113 */     setRotation(this.llegtop3, 0.0F, 0.3490659F, 0.3839724F);
/* 114 */     this.llegbot3 = new ModelRenderer(this, 15, 25);
/* 115 */     this.llegbot3.addBox(5.0F, -3.0F, 0.0F, 3, 1, 1);
/* 116 */     this.llegbot3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 117 */     this.llegbot3.setTextureSize(64, 32);
/* 118 */     this.llegbot3.mirror = true;
/* 119 */     setRotation(this.llegbot3, 0.0F, 0.3490659F, 1.064651F);
/* 120 */     this.rlegtop1 = new ModelRenderer(this, 25, 10);
/* 121 */     this.rlegtop1.addBox(-4.0F, 2.0F, 1.0F, 3, 1, 1);
/* 122 */     this.rlegtop1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 123 */     this.rlegtop1.setTextureSize(64, 32);
/* 124 */     this.rlegtop1.mirror = true;
/* 125 */     setRotation(this.rlegtop1, 0.0F, 0.0F, -0.4712389F);
/* 126 */     this.rlegbot1 = new ModelRenderer(this, 25, 19);
/* 127 */     this.rlegbot1.addBox(-7.0F, 0.0F, 1.0F, 3, 1, 1);
/* 128 */     this.rlegbot1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 129 */     this.rlegbot1.setTextureSize(64, 32);
/* 130 */     this.rlegbot1.mirror = true;
/* 131 */     setRotation(this.rlegbot1, 0.0F, 0.0F, -0.9773844F);
/* 132 */     this.rlegtop2 = new ModelRenderer(this, 25, 13);
/* 133 */     this.rlegtop2.addBox(-4.0F, 2.0F, 0.0F, 3, 1, 1);
/* 134 */     this.rlegtop2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 135 */     this.rlegtop2.setTextureSize(64, 32);
/* 136 */     this.rlegtop2.mirror = true;
/* 137 */     setRotation(this.rlegtop2, 0.0F, -0.5934119F, -0.4712389F);
/* 138 */     this.rlegbot2 = new ModelRenderer(this, 25, 22);
/* 139 */     this.rlegbot2.addBox(-7.0F, 0.0F, 0.0F, 3, 1, 1);
/* 140 */     this.rlegbot2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 141 */     this.rlegbot2.setTextureSize(64, 32);
/* 142 */     this.rlegbot2.mirror = true;
/* 143 */     setRotation(this.rlegbot2, 0.0F, -0.5934119F, -0.9773844F);
/* 144 */     this.rlegtop3 = new ModelRenderer(this, 25, 16);
/* 145 */     this.rlegtop3.addBox(-4.0F, 2.0F, 2.0F, 3, 1, 1);
/* 146 */     this.rlegtop3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 147 */     this.rlegtop3.setTextureSize(64, 32);
/* 148 */     this.rlegtop3.mirror = true;
/* 149 */     setRotation(this.rlegtop3, 0.0F, 0.418879F, -0.4712389F);
/* 150 */     this.rlegbot3 = new ModelRenderer(this, 25, 25);
/* 151 */     this.rlegbot3.addBox(-7.0F, 0.0F, 2.0F, 3, 1, 1);
/* 152 */     this.rlegbot3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 153 */     this.rlegbot3.setTextureSize(64, 32);
/* 154 */     this.rlegbot3.mirror = true;
/* 155 */     setRotation(this.rlegbot3, 0.0F, 0.418879F, -0.9773844F);
/*     */   }
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 159 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 160 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 163 */     this.llegtop1.rotateAngleX = MathHelper.cos(f2 * 2.7F) * 3.1415927F * 0.45F * f1;
/* 164 */     this.llegbot1.rotateAngleX = this.llegtop1.rotateAngleX;
/* 165 */     this.rlegtop2.rotateAngleX = this.llegtop1.rotateAngleX;
/* 166 */     this.rlegbot2.rotateAngleX = this.llegtop1.rotateAngleX;
/* 167 */     this.rlegtop3.rotateAngleX = this.llegtop1.rotateAngleX;
/* 168 */     this.rlegbot3.rotateAngleX = this.llegtop1.rotateAngleX;
/*     */     
/* 170 */     this.rlegtop1.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 171 */     this.rlegbot1.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 172 */     this.llegtop2.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 173 */     this.llegbot2.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 174 */     this.llegtop3.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 175 */     this.llegbot3.rotateAngleX = -this.llegtop1.rotateAngleX;
/*     */     
/* 177 */     this.jawsl.rotateAngleY = MathHelper.cos(f2 * 0.4F) * 3.1415927F * 0.05F;
/* 178 */     this.jawsr.rotateAngleY = -this.jawsl.rotateAngleY;
/*     */     
/* 180 */     GL11.glPushMatrix();
/*     */     
/* 182 */     GL11.glTranslatef(0.0F, 0.9F, 0.0F);
/*     */     
/* 184 */     GL11.glScalef(0.4F, 0.4F, 0.4F);
/*     */     
/* 186 */     this.thorax.render(f5);
/* 187 */     this.thorax1.render(f5);
/* 188 */     this.thorax3.render(f5);
/* 189 */     this.abdomen.render(f5);
/* 190 */     this.abdomen1.render(f5);
/* 191 */     this.head.render(f5);
/* 192 */     this.jawsr.render(f5);
/* 193 */     this.jawsl.render(f5);
/* 194 */     this.llegtop1.render(f5);
/* 195 */     this.llegbot1.render(f5);
/* 196 */     this.llegtop2.render(f5);
/* 197 */     this.llegbot2.render(f5);
/* 198 */     this.llegtop3.render(f5);
/* 199 */     this.llegbot3.render(f5);
/* 200 */     this.rlegtop1.render(f5);
/* 201 */     this.rlegbot1.render(f5);
/* 202 */     this.rlegtop2.render(f5);
/* 203 */     this.rlegbot2.render(f5);
/* 204 */     this.rlegtop3.render(f5);
/* 205 */     this.rlegbot3.render(f5);
/*     */     
/* 207 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 211 */     model.rotateAngleX = x;
/* 212 */     model.rotateAngleY = y;
/* 213 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 217 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\entity\model\ModelAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */