/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
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
/*  36 */     this.textureWidth = 64;
/*  37 */     this.textureHeight = 32;
/*  38 */     this.thorax = new ModelRenderer(this, 22, 0);
/*  39 */     this.thorax.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
/*  40 */     this.thorax.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  41 */     this.thorax.setTextureSize(64, 32);
/*  42 */     this.thorax.mirror = true;
/*  43 */     setRotation(this.thorax, 0.0F, 0.0F, 0.0F);
/*  44 */     this.thorax1 = new ModelRenderer(this, 18, 0);
/*  45 */     this.thorax1.addBox(1.0F, 1.0F, -1.0F, 1, 1, 1);
/*  46 */     this.thorax1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  47 */     this.thorax1.setTextureSize(64, 32);
/*  48 */     this.thorax1.mirror = true;
/*  49 */     setRotation(this.thorax1, 0.0F, 0.0F, 0.0F);
/*  50 */     this.thorax3 = new ModelRenderer(this, 34, 0);
/*  51 */     this.thorax3.addBox(1.0F, 1.0F, 3.0F, 1, 1, 1);
/*  52 */     this.thorax3.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  53 */     this.thorax3.setTextureSize(64, 32);
/*  54 */     this.thorax3.mirror = true;
/*  55 */     setRotation(this.thorax3, 0.0F, 0.0F, 0.0F);
/*  56 */     this.abdomen = new ModelRenderer(this, 38, 0);
/*  57 */     this.abdomen.addBox(0.0F, 0.0F, 4.0F, 3, 3, 5);
/*  58 */     this.abdomen.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  59 */     this.abdomen.setTextureSize(64, 32);
/*  60 */     this.abdomen.mirror = true;
/*  61 */     setRotation(this.abdomen, 0.0F, 0.0F, 0.0F);
/*  62 */     this.abdomen1 = new ModelRenderer(this, 54, 0);
/*  63 */     this.abdomen1.addBox(1.0F, 1.0F, 9.0F, 1, 1, 1);
/*  64 */     this.abdomen1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  65 */     this.abdomen1.setTextureSize(64, 32);
/*  66 */     this.abdomen1.mirror = true;
/*  67 */     setRotation(this.abdomen1, 0.0F, 0.0F, 0.0F);
/*  68 */     this.head = new ModelRenderer(this, 6, 0);
/*  69 */     this.head.addBox(0.0F, -1.0F, -4.0F, 3, 3, 3);
/*  70 */     this.head.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  71 */     this.head.setTextureSize(64, 32);
/*  72 */     this.head.mirror = true;
/*  73 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  74 */     this.jawsr = new ModelRenderer(this, 0, 9);
/*  75 */     this.jawsr.addBox(-1.0F, 0.0F, -6.0F, 1, 1, 3);
/*  76 */     this.jawsr.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  77 */     this.jawsr.setTextureSize(64, 32);
/*  78 */     this.jawsr.mirror = true;
/*  79 */     setRotation(this.jawsr, 0.0F, 0.0F, 0.0F);
/*  80 */     this.jawsl = new ModelRenderer(this, 0, 14);
/*  81 */     this.jawsl.addBox(3.0F, 0.0F, -6.0F, 1, 1, 3);
/*  82 */     this.jawsl.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  83 */     this.jawsl.setTextureSize(64, 32);
/*  84 */     this.jawsl.mirror = true;
/*  85 */     setRotation(this.jawsl, 0.0F, 0.0F, 0.0F);
/*  86 */     this.llegtop1 = new ModelRenderer(this, 15, 10);
/*  87 */     this.llegtop1.addBox(3.0F, 1.0F, 1.0F, 3, 1, 1);
/*  88 */     this.llegtop1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  89 */     this.llegtop1.setTextureSize(64, 32);
/*  90 */     this.llegtop1.mirror = true;
/*  91 */     setRotation(this.llegtop1, 0.0F, 0.0F, 0.3839724F);
/*  92 */     this.llegbot1 = new ModelRenderer(this, 15, 19);
/*  93 */     this.llegbot1.addBox(5.0F, -3.0F, 1.0F, 3, 1, 1);
/*  94 */     this.llegbot1.setRotationPoint(0.0F, 17.0F, 0.0F);
/*  95 */     this.llegbot1.setTextureSize(64, 32);
/*  96 */     this.llegbot1.mirror = true;
/*  97 */     setRotation(this.llegbot1, 0.0F, 0.0F, 1.064651F);
/*  98 */     this.llegtop2 = new ModelRenderer(this, 15, 13);
/*  99 */     this.llegtop2.addBox(3.0F, 1.0F, 2.0F, 3, 1, 1);
/* 100 */     this.llegtop2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 101 */     this.llegtop2.setTextureSize(64, 32);
/* 102 */     this.llegtop2.mirror = true;
/* 103 */     setRotation(this.llegtop2, 0.0F, -0.2094395F, 0.3839724F);
/* 104 */     this.llegbot2 = new ModelRenderer(this, 15, 22);
/* 105 */     this.llegbot2.addBox(5.0F, -3.0F, 2.0F, 3, 1, 1);
/* 106 */     this.llegbot2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 107 */     this.llegbot2.setTextureSize(64, 32);
/* 108 */     this.llegbot2.mirror = true;
/* 109 */     setRotation(this.llegbot2, 0.0F, -0.2268928F, 1.064651F);
/* 110 */     this.llegtop3 = new ModelRenderer(this, 15, 16);
/* 111 */     this.llegtop3.addBox(3.0F, 1.0F, 0.0F, 3, 1, 1);
/* 112 */     this.llegtop3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 113 */     this.llegtop3.setTextureSize(64, 32);
/* 114 */     this.llegtop3.mirror = true;
/* 115 */     setRotation(this.llegtop3, 0.0F, 0.3490659F, 0.3839724F);
/* 116 */     this.llegbot3 = new ModelRenderer(this, 15, 25);
/* 117 */     this.llegbot3.addBox(5.0F, -3.0F, 0.0F, 3, 1, 1);
/* 118 */     this.llegbot3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 119 */     this.llegbot3.setTextureSize(64, 32);
/* 120 */     this.llegbot3.mirror = true;
/* 121 */     setRotation(this.llegbot3, 0.0F, 0.3490659F, 1.064651F);
/* 122 */     this.rlegtop1 = new ModelRenderer(this, 25, 10);
/* 123 */     this.rlegtop1.addBox(-4.0F, 2.0F, 1.0F, 3, 1, 1);
/* 124 */     this.rlegtop1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 125 */     this.rlegtop1.setTextureSize(64, 32);
/* 126 */     this.rlegtop1.mirror = true;
/* 127 */     setRotation(this.rlegtop1, 0.0F, 0.0F, -0.4712389F);
/* 128 */     this.rlegbot1 = new ModelRenderer(this, 25, 19);
/* 129 */     this.rlegbot1.addBox(-7.0F, 0.0F, 1.0F, 3, 1, 1);
/* 130 */     this.rlegbot1.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 131 */     this.rlegbot1.setTextureSize(64, 32);
/* 132 */     this.rlegbot1.mirror = true;
/* 133 */     setRotation(this.rlegbot1, 0.0F, 0.0F, -0.9773844F);
/* 134 */     this.rlegtop2 = new ModelRenderer(this, 25, 13);
/* 135 */     this.rlegtop2.addBox(-4.0F, 2.0F, 0.0F, 3, 1, 1);
/* 136 */     this.rlegtop2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 137 */     this.rlegtop2.setTextureSize(64, 32);
/* 138 */     this.rlegtop2.mirror = true;
/* 139 */     setRotation(this.rlegtop2, 0.0F, -0.5934119F, -0.4712389F);
/* 140 */     this.rlegbot2 = new ModelRenderer(this, 25, 22);
/* 141 */     this.rlegbot2.addBox(-7.0F, 0.0F, 0.0F, 3, 1, 1);
/* 142 */     this.rlegbot2.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 143 */     this.rlegbot2.setTextureSize(64, 32);
/* 144 */     this.rlegbot2.mirror = true;
/* 145 */     setRotation(this.rlegbot2, 0.0F, -0.5934119F, -0.9773844F);
/* 146 */     this.rlegtop3 = new ModelRenderer(this, 25, 16);
/* 147 */     this.rlegtop3.addBox(-4.0F, 2.0F, 2.0F, 3, 1, 1);
/* 148 */     this.rlegtop3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 149 */     this.rlegtop3.setTextureSize(64, 32);
/* 150 */     this.rlegtop3.mirror = true;
/* 151 */     setRotation(this.rlegtop3, 0.0F, 0.418879F, -0.4712389F);
/* 152 */     this.rlegbot3 = new ModelRenderer(this, 25, 25);
/* 153 */     this.rlegbot3.addBox(-7.0F, 0.0F, 2.0F, 3, 1, 1);
/* 154 */     this.rlegbot3.setRotationPoint(0.0F, 17.0F, 0.0F);
/* 155 */     this.rlegbot3.setTextureSize(64, 32);
/* 156 */     this.rlegbot3.mirror = true;
/* 157 */     setRotation(this.rlegbot3, 0.0F, 0.418879F, -0.9773844F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 162 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 163 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 166 */     this.llegtop1.rotateAngleX = MathHelper.cos(f2 * 2.7F) * 3.1415927F * 0.45F * f1;
/* 167 */     this.llegbot1.rotateAngleX = this.llegtop1.rotateAngleX;
/* 168 */     this.rlegtop2.rotateAngleX = this.llegtop1.rotateAngleX;
/* 169 */     this.rlegbot2.rotateAngleX = this.llegtop1.rotateAngleX;
/* 170 */     this.rlegtop3.rotateAngleX = this.llegtop1.rotateAngleX;
/* 171 */     this.rlegbot3.rotateAngleX = this.llegtop1.rotateAngleX;
/*     */     
/* 173 */     this.rlegtop1.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 174 */     this.rlegbot1.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 175 */     this.llegtop2.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 176 */     this.llegbot2.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 177 */     this.llegtop3.rotateAngleX = -this.llegtop1.rotateAngleX;
/* 178 */     this.llegbot3.rotateAngleX = -this.llegtop1.rotateAngleX;
/*     */     
/* 180 */     this.jawsl.rotateAngleY = MathHelper.cos(f2 * 0.4F) * 3.1415927F * 0.05F;
/* 181 */     this.jawsr.rotateAngleY = -this.jawsl.rotateAngleY;
/*     */     
/* 183 */     GL11.glPushMatrix();
/*     */     
/* 185 */     GL11.glTranslatef(0.0F, 0.9F, 0.0F);
/*     */     
/* 187 */     GL11.glScalef(0.4F, 0.4F, 0.4F);
/*     */     
/* 189 */     this.thorax.render(f5);
/* 190 */     this.thorax1.render(f5);
/* 191 */     this.thorax3.render(f5);
/* 192 */     this.abdomen.render(f5);
/* 193 */     this.abdomen1.render(f5);
/* 194 */     this.head.render(f5);
/* 195 */     this.jawsr.render(f5);
/* 196 */     this.jawsl.render(f5);
/* 197 */     this.llegtop1.render(f5);
/* 198 */     this.llegbot1.render(f5);
/* 199 */     this.llegtop2.render(f5);
/* 200 */     this.llegbot2.render(f5);
/* 201 */     this.llegtop3.render(f5);
/* 202 */     this.llegbot3.render(f5);
/* 203 */     this.rlegtop1.render(f5);
/* 204 */     this.rlegbot1.render(f5);
/* 205 */     this.rlegtop2.render(f5);
/* 206 */     this.rlegbot2.render(f5);
/* 207 */     this.rlegtop3.render(f5);
/* 208 */     this.rlegbot3.render(f5);
/*     */     
/* 210 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 215 */     model.rotateAngleX = x;
/* 216 */     model.rotateAngleY = y;
/* 217 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 222 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\model\ModelAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */