/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelCryolophosaurus
/*     */   extends ModelBase
/*     */ {
/*  12 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape1;
/*     */   
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer jaw;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape9;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer rightleg2;
/*     */   ModelRenderer rightleg3;
/*     */   ModelRenderer rightleg4;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer Shape16;
/*     */   ModelRenderer Shape17;
/*     */   ModelRenderer leftleg2;
/*     */   ModelRenderer leftleg3;
/*     */   ModelRenderer leftleg4;
/*     */   
/*     */   public ModelCryolophosaurus(float f1) {
/*  37 */     this.textureWidth = 128;
/*  38 */     this.textureHeight = 128;
/*  39 */     this.wingspeed = f1;
/*     */     
/*  41 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  42 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 8, 9, 18);
/*  43 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  44 */     this.Shape1.setTextureSize(128, 128);
/*  45 */     this.Shape1.mirror = true;
/*  46 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  47 */     this.Shape2 = new ModelRenderer(this, 53, 0);
/*  48 */     this.Shape2.addBox(0.0F, 0.0F, 0.0F, 6, 4, 11);
/*  49 */     this.Shape2.setRotationPoint(1.0F, -2.0F, -7.0F);
/*  50 */     this.Shape2.setTextureSize(128, 128);
/*  51 */     this.Shape2.mirror = true;
/*  52 */     setRotation(this.Shape2, -0.2268928F, 0.0F, 0.0F);
/*  53 */     this.Shape3 = new ModelRenderer(this, 0, 41);
/*  54 */     this.Shape3.addBox(0.0F, 0.0F, 0.0F, 6, 4, 10);
/*  55 */     this.Shape3.setRotationPoint(1.0F, -2.0F, -15.0F);
/*  56 */     this.Shape3.setTextureSize(128, 128);
/*  57 */     this.Shape3.mirror = true;
/*  58 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  59 */     this.jaw = new ModelRenderer(this, 0, 30);
/*  60 */     this.jaw.addBox(0.0F, 0.0F, 0.0F, 4, 9, 1);
/*  61 */     this.jaw.setRotationPoint(2.0F, 1.0F, -8.0F);
/*  62 */     this.jaw.setTextureSize(128, 128);
/*  63 */     this.jaw.mirror = true;
/*  64 */     setRotation(this.jaw, -1.256637F, 0.0F, 0.0F);
/*  65 */     this.Shape5 = new ModelRenderer(this, 91, 0);
/*  66 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 6, 6, 7);
/*  67 */     this.Shape5.setRotationPoint(1.0F, 0.0F, 18.0F);
/*  68 */     this.Shape5.setTextureSize(128, 128);
/*  69 */     this.Shape5.mirror = true;
/*  70 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  71 */     this.Shape6 = new ModelRenderer(this, 36, 31);
/*  72 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 4, 4, 14);
/*  73 */     this.Shape6.setRotationPoint(2.0F, 0.0F, 25.0F);
/*  74 */     this.Shape6.setTextureSize(128, 128);
/*  75 */     this.Shape6.mirror = true;
/*  76 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/*  77 */     this.Shape7 = new ModelRenderer(this, 43, 8);
/*  78 */     this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2);
/*  79 */     this.Shape7.setRotationPoint(-1.0F, 8.0F, 0.0F);
/*  80 */     this.Shape7.setTextureSize(128, 128);
/*  81 */     this.Shape7.mirror = true;
/*  82 */     setRotation(this.Shape7, 0.1919862F, 0.0F, 0.0F);
/*  83 */     this.Shape8 = new ModelRenderer(this, 9, 0);
/*  84 */     this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/*  85 */     this.Shape8.setRotationPoint(-1.0F, 11.0F, 1.0F);
/*  86 */     this.Shape8.setTextureSize(128, 128);
/*  87 */     this.Shape8.mirror = true;
/*  88 */     setRotation(this.Shape8, -0.2617994F, 0.0F, 0.0F);
/*  89 */     this.Shape9 = new ModelRenderer(this, 0, 0);
/*  90 */     this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1);
/*  91 */     this.Shape9.setRotationPoint(3.0F, -4.0F, -9.0F);
/*  92 */     this.Shape9.setTextureSize(128, 128);
/*  93 */     this.Shape9.mirror = true;
/*  94 */     setRotation(this.Shape9, -0.9424778F, 0.0F, 0.0F);
/*  95 */     this.rightleg = new ModelRenderer(this, 0, 58);
/*  96 */     this.rightleg.addBox(0.0F, 0.0F, 0.0F, 2, 10, 6);
/*  97 */     this.rightleg.setRotationPoint(-1.0F, 2.0F, 12.0F);
/*  98 */     this.rightleg.setTextureSize(128, 128);
/*  99 */     this.rightleg.mirror = true;
/* 100 */     setRotation(this.rightleg, -0.2792527F, 0.0F, 0.0F);
/* 101 */     this.Shape11 = new ModelRenderer(this, 39, 0);
/* 102 */     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3);
/* 103 */     this.Shape11.setRotationPoint(2.0F, -1.0F, -18.0F);
/* 104 */     this.Shape11.setTextureSize(128, 128);
/* 105 */     this.Shape11.mirror = true;
/* 106 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/* 107 */     this.rightleg2 = new ModelRenderer(this, 0, 77);
/* 108 */     this.rightleg2.addBox(0.0F, 7.0F, -5.0F, 2, 10, 3);
/* 109 */     this.rightleg2.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 110 */     this.rightleg2.setTextureSize(128, 128);
/* 111 */     this.rightleg2.mirror = true;
/* 112 */     setRotation(this.rightleg2, 0.3839724F, 0.0F, 0.0F);
/* 113 */     this.rightleg3 = new ModelRenderer(this, 35, 31);
/* 114 */     this.rightleg3.addBox(0.0F, 10.0F, 12.0F, 2, 7, 2);
/* 115 */     this.rightleg3.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 116 */     this.rightleg3.setTextureSize(128, 128);
/* 117 */     this.rightleg3.mirror = true;
/* 118 */     setRotation(this.rightleg3, -0.6806784F, 0.0F, 0.0F);
/* 119 */     this.rightleg4 = new ModelRenderer(this, 68, 55);
/* 120 */     this.rightleg4.addBox(0.0F, 20.0F, -5.0F, 2, 2, 6);
/* 121 */     this.rightleg4.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 122 */     this.rightleg4.setTextureSize(128, 128);
/* 123 */     this.rightleg4.mirror = true;
/* 124 */     setRotation(this.rightleg4, 0.0F, 0.0F, 0.0F);
/* 125 */     this.leftleg = new ModelRenderer(this, 22, 58);
/* 126 */     this.leftleg.addBox(0.0F, 0.0F, 0.0F, 2, 10, 6);
/* 127 */     this.leftleg.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 128 */     this.leftleg.setTextureSize(128, 128);
/* 129 */     this.leftleg.mirror = true;
/* 130 */     setRotation(this.leftleg, -0.2792527F, 0.0F, 0.0F);
/* 131 */     this.Shape16 = new ModelRenderer(this, 0, 8);
/* 132 */     this.Shape16.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2);
/* 133 */     this.Shape16.setRotationPoint(8.0F, 8.0F, 0.0F);
/* 134 */     this.Shape16.setTextureSize(128, 128);
/* 135 */     this.Shape16.mirror = true;
/* 136 */     setRotation(this.Shape16, 0.1919862F, 0.0F, 0.0F);
/* 137 */     this.Shape17 = new ModelRenderer(this, 9, 9);
/* 138 */     this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 139 */     this.Shape17.setRotationPoint(8.0F, 11.0F, 1.0F);
/* 140 */     this.Shape17.setTextureSize(128, 128);
/* 141 */     this.Shape17.mirror = true;
/* 142 */     setRotation(this.Shape17, -0.2617994F, 0.0F, 0.0F);
/* 143 */     this.leftleg2 = new ModelRenderer(this, 16, 77);
/* 144 */     this.leftleg2.addBox(0.0F, 7.0F, -5.0F, 2, 10, 3);
/* 145 */     this.leftleg2.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 146 */     this.leftleg2.setTextureSize(128, 128);
/* 147 */     this.leftleg2.mirror = true;
/* 148 */     setRotation(this.leftleg2, 0.3839724F, 0.0F, 0.0F);
/* 149 */     this.leftleg3 = new ModelRenderer(this, 67, 31);
/* 150 */     this.leftleg3.addBox(0.0F, 10.0F, 12.0F, 2, 7, 2);
/* 151 */     this.leftleg3.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 152 */     this.leftleg3.setTextureSize(128, 128);
/* 153 */     this.leftleg3.mirror = true;
/* 154 */     setRotation(this.leftleg3, -0.6806784F, 0.0F, 0.0F);
/* 155 */     this.leftleg4 = new ModelRenderer(this, 47, 56);
/* 156 */     this.leftleg4.addBox(0.0F, 20.0F, -5.0F, 2, 2, 6);
/* 157 */     this.leftleg4.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 158 */     this.leftleg4.setTextureSize(128, 128);
/* 159 */     this.leftleg4.mirror = true;
/* 160 */     setRotation(this.leftleg4, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 167 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 168 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 170 */     float newangle = 0.0F;
/*     */     
/* 172 */     if (f1 > 0.1D) {
/* 173 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 175 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 178 */     this.rightleg.rotateAngleX = -0.2792527F + newangle;
/* 179 */     this.rightleg2.rotateAngleX = 0.384F + newangle;
/* 180 */     this.rightleg3.rotateAngleX = -0.68F + newangle;
/* 181 */     this.rightleg4.rotateAngleX = newangle;
/*     */     
/* 183 */     this.leftleg.rotateAngleX = -0.2792527F - newangle;
/* 184 */     this.leftleg2.rotateAngleX = 0.384F - newangle;
/* 185 */     this.leftleg3.rotateAngleX = -0.68F - newangle;
/* 186 */     this.leftleg4.rotateAngleX = -newangle;
/*     */     
/* 188 */     this.jaw.rotateAngleX = -1.15F + MathHelper.cos(f2 * 0.28F) * 3.1415927F * 0.1F;
/*     */ 
/*     */     
/* 191 */     GL11.glPushMatrix();
/*     */     
/* 193 */     GL11.glTranslatef(0.0F, 0.67499995F, 0.0F);
/*     */     
/* 195 */     GL11.glScalef(0.55F, 0.55F, 0.55F);
/*     */     
/* 197 */     this.Shape1.render(f5);
/* 198 */     this.Shape2.render(f5);
/* 199 */     this.Shape3.render(f5);
/* 200 */     this.jaw.render(f5);
/* 201 */     this.Shape5.render(f5);
/* 202 */     this.Shape6.render(f5);
/* 203 */     this.Shape7.render(f5);
/* 204 */     this.Shape8.render(f5);
/* 205 */     this.Shape9.render(f5);
/* 206 */     this.rightleg.render(f5);
/* 207 */     this.Shape11.render(f5);
/* 208 */     this.rightleg2.render(f5);
/* 209 */     this.rightleg3.render(f5);
/* 210 */     this.rightleg4.render(f5);
/* 211 */     this.leftleg.render(f5);
/* 212 */     this.Shape16.render(f5);
/* 213 */     this.Shape17.render(f5);
/* 214 */     this.leftleg2.render(f5);
/* 215 */     this.leftleg3.render(f5);
/* 216 */     this.leftleg4.render(f5);
/*     */ 
/*     */ 
/*     */     
/* 220 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 226 */     model.rotateAngleX = x;
/* 227 */     model.rotateAngleY = y;
/* 228 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 232 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\model\ModelCryolophosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */