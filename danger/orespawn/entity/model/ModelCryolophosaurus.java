/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelCryolophosaurus
/*     */   extends ModelBase
/*     */ {
/*  13 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape1;
/*     */   
/*     */   ModelRenderer Shape2;
/*     */   
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
/*  39 */     this.textureWidth = 128;
/*  40 */     this.textureHeight = 128;
/*  41 */     this.wingspeed = f1;
/*     */     
/*  43 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  44 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 8, 9, 18);
/*  45 */     this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  46 */     this.Shape1.setTextureSize(128, 128);
/*  47 */     this.Shape1.mirror = true;
/*  48 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  49 */     this.Shape2 = new ModelRenderer(this, 53, 0);
/*  50 */     this.Shape2.addBox(0.0F, 0.0F, 0.0F, 6, 4, 11);
/*  51 */     this.Shape2.setRotationPoint(1.0F, -2.0F, -7.0F);
/*  52 */     this.Shape2.setTextureSize(128, 128);
/*  53 */     this.Shape2.mirror = true;
/*  54 */     setRotation(this.Shape2, -0.2268928F, 0.0F, 0.0F);
/*  55 */     this.Shape3 = new ModelRenderer(this, 0, 41);
/*  56 */     this.Shape3.addBox(0.0F, 0.0F, 0.0F, 6, 4, 10);
/*  57 */     this.Shape3.setRotationPoint(1.0F, -2.0F, -15.0F);
/*  58 */     this.Shape3.setTextureSize(128, 128);
/*  59 */     this.Shape3.mirror = true;
/*  60 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  61 */     this.jaw = new ModelRenderer(this, 0, 30);
/*  62 */     this.jaw.addBox(0.0F, 0.0F, 0.0F, 4, 9, 1);
/*  63 */     this.jaw.setRotationPoint(2.0F, 1.0F, -8.0F);
/*  64 */     this.jaw.setTextureSize(128, 128);
/*  65 */     this.jaw.mirror = true;
/*  66 */     setRotation(this.jaw, -1.256637F, 0.0F, 0.0F);
/*  67 */     this.Shape5 = new ModelRenderer(this, 91, 0);
/*  68 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 6, 6, 7);
/*  69 */     this.Shape5.setRotationPoint(1.0F, 0.0F, 18.0F);
/*  70 */     this.Shape5.setTextureSize(128, 128);
/*  71 */     this.Shape5.mirror = true;
/*  72 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  73 */     this.Shape6 = new ModelRenderer(this, 36, 31);
/*  74 */     this.Shape6.addBox(0.0F, 0.0F, 0.0F, 4, 4, 14);
/*  75 */     this.Shape6.setRotationPoint(2.0F, 0.0F, 25.0F);
/*  76 */     this.Shape6.setTextureSize(128, 128);
/*  77 */     this.Shape6.mirror = true;
/*  78 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/*  79 */     this.Shape7 = new ModelRenderer(this, 43, 8);
/*  80 */     this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2);
/*  81 */     this.Shape7.setRotationPoint(-1.0F, 8.0F, 0.0F);
/*  82 */     this.Shape7.setTextureSize(128, 128);
/*  83 */     this.Shape7.mirror = true;
/*  84 */     setRotation(this.Shape7, 0.1919862F, 0.0F, 0.0F);
/*  85 */     this.Shape8 = new ModelRenderer(this, 9, 0);
/*  86 */     this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/*  87 */     this.Shape8.setRotationPoint(-1.0F, 11.0F, 1.0F);
/*  88 */     this.Shape8.setTextureSize(128, 128);
/*  89 */     this.Shape8.mirror = true;
/*  90 */     setRotation(this.Shape8, -0.2617994F, 0.0F, 0.0F);
/*  91 */     this.Shape9 = new ModelRenderer(this, 0, 0);
/*  92 */     this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1);
/*  93 */     this.Shape9.setRotationPoint(3.0F, -4.0F, -9.0F);
/*  94 */     this.Shape9.setTextureSize(128, 128);
/*  95 */     this.Shape9.mirror = true;
/*  96 */     setRotation(this.Shape9, -0.9424778F, 0.0F, 0.0F);
/*  97 */     this.rightleg = new ModelRenderer(this, 0, 58);
/*  98 */     this.rightleg.addBox(0.0F, 0.0F, 0.0F, 2, 10, 6);
/*  99 */     this.rightleg.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 100 */     this.rightleg.setTextureSize(128, 128);
/* 101 */     this.rightleg.mirror = true;
/* 102 */     setRotation(this.rightleg, -0.2792527F, 0.0F, 0.0F);
/* 103 */     this.Shape11 = new ModelRenderer(this, 39, 0);
/* 104 */     this.Shape11.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3);
/* 105 */     this.Shape11.setRotationPoint(2.0F, -1.0F, -18.0F);
/* 106 */     this.Shape11.setTextureSize(128, 128);
/* 107 */     this.Shape11.mirror = true;
/* 108 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/* 109 */     this.rightleg2 = new ModelRenderer(this, 0, 77);
/* 110 */     this.rightleg2.addBox(0.0F, 7.0F, -5.0F, 2, 10, 3);
/* 111 */     this.rightleg2.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 112 */     this.rightleg2.setTextureSize(128, 128);
/* 113 */     this.rightleg2.mirror = true;
/* 114 */     setRotation(this.rightleg2, 0.3839724F, 0.0F, 0.0F);
/* 115 */     this.rightleg3 = new ModelRenderer(this, 35, 31);
/* 116 */     this.rightleg3.addBox(0.0F, 10.0F, 12.0F, 2, 7, 2);
/* 117 */     this.rightleg3.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 118 */     this.rightleg3.setTextureSize(128, 128);
/* 119 */     this.rightleg3.mirror = true;
/* 120 */     setRotation(this.rightleg3, -0.6806784F, 0.0F, 0.0F);
/* 121 */     this.rightleg4 = new ModelRenderer(this, 68, 55);
/* 122 */     this.rightleg4.addBox(0.0F, 20.0F, -5.0F, 2, 2, 6);
/* 123 */     this.rightleg4.setRotationPoint(-1.0F, 2.0F, 12.0F);
/* 124 */     this.rightleg4.setTextureSize(128, 128);
/* 125 */     this.rightleg4.mirror = true;
/* 126 */     setRotation(this.rightleg4, 0.0F, 0.0F, 0.0F);
/* 127 */     this.leftleg = new ModelRenderer(this, 22, 58);
/* 128 */     this.leftleg.addBox(0.0F, 0.0F, 0.0F, 2, 10, 6);
/* 129 */     this.leftleg.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 130 */     this.leftleg.setTextureSize(128, 128);
/* 131 */     this.leftleg.mirror = true;
/* 132 */     setRotation(this.leftleg, -0.2792527F, 0.0F, 0.0F);
/* 133 */     this.Shape16 = new ModelRenderer(this, 0, 8);
/* 134 */     this.Shape16.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2);
/* 135 */     this.Shape16.setRotationPoint(8.0F, 8.0F, 0.0F);
/* 136 */     this.Shape16.setTextureSize(128, 128);
/* 137 */     this.Shape16.mirror = true;
/* 138 */     setRotation(this.Shape16, 0.1919862F, 0.0F, 0.0F);
/* 139 */     this.Shape17 = new ModelRenderer(this, 9, 9);
/* 140 */     this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 141 */     this.Shape17.setRotationPoint(8.0F, 11.0F, 1.0F);
/* 142 */     this.Shape17.setTextureSize(128, 128);
/* 143 */     this.Shape17.mirror = true;
/* 144 */     setRotation(this.Shape17, -0.2617994F, 0.0F, 0.0F);
/* 145 */     this.leftleg2 = new ModelRenderer(this, 16, 77);
/* 146 */     this.leftleg2.addBox(0.0F, 7.0F, -5.0F, 2, 10, 3);
/* 147 */     this.leftleg2.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 148 */     this.leftleg2.setTextureSize(128, 128);
/* 149 */     this.leftleg2.mirror = true;
/* 150 */     setRotation(this.leftleg2, 0.3839724F, 0.0F, 0.0F);
/* 151 */     this.leftleg3 = new ModelRenderer(this, 67, 31);
/* 152 */     this.leftleg3.addBox(0.0F, 10.0F, 12.0F, 2, 7, 2);
/* 153 */     this.leftleg3.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 154 */     this.leftleg3.setTextureSize(128, 128);
/* 155 */     this.leftleg3.mirror = true;
/* 156 */     setRotation(this.leftleg3, -0.6806784F, 0.0F, 0.0F);
/* 157 */     this.leftleg4 = new ModelRenderer(this, 47, 56);
/* 158 */     this.leftleg4.addBox(0.0F, 20.0F, -5.0F, 2, 2, 6);
/* 159 */     this.leftleg4.setRotationPoint(7.0F, 2.0F, 12.0F);
/* 160 */     this.leftleg4.setTextureSize(128, 128);
/* 161 */     this.leftleg4.mirror = true;
/* 162 */     setRotation(this.leftleg4, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 170 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 171 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 173 */     float newangle = 0.0F;
/*     */     
/* 175 */     if (f1 > 0.1D) {
/* 176 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 178 */       newangle = 0.0F;
/*     */     } 
/*     */     
/* 181 */     this.rightleg.rotateAngleX = -0.2792527F + newangle;
/* 182 */     this.rightleg2.rotateAngleX = 0.384F + newangle;
/* 183 */     this.rightleg3.rotateAngleX = -0.68F + newangle;
/* 184 */     this.rightleg4.rotateAngleX = newangle;
/*     */     
/* 186 */     this.leftleg.rotateAngleX = -0.2792527F - newangle;
/* 187 */     this.leftleg2.rotateAngleX = 0.384F - newangle;
/* 188 */     this.leftleg3.rotateAngleX = -0.68F - newangle;
/* 189 */     this.leftleg4.rotateAngleX = -newangle;
/*     */     
/* 191 */     this.jaw.rotateAngleX = -1.15F + MathHelper.cos(f2 * 0.28F) * 3.1415927F * 0.1F;
/*     */ 
/*     */     
/* 194 */     GL11.glPushMatrix();
/*     */     
/* 196 */     GL11.glTranslatef(0.0F, 0.67499995F, 0.0F);
/*     */     
/* 198 */     GL11.glScalef(0.55F, 0.55F, 0.55F);
/*     */     
/* 200 */     this.Shape1.render(f5);
/* 201 */     this.Shape2.render(f5);
/* 202 */     this.Shape3.render(f5);
/* 203 */     this.jaw.render(f5);
/* 204 */     this.Shape5.render(f5);
/* 205 */     this.Shape6.render(f5);
/* 206 */     this.Shape7.render(f5);
/* 207 */     this.Shape8.render(f5);
/* 208 */     this.Shape9.render(f5);
/* 209 */     this.rightleg.render(f5);
/* 210 */     this.Shape11.render(f5);
/* 211 */     this.rightleg2.render(f5);
/* 212 */     this.rightleg3.render(f5);
/* 213 */     this.rightleg4.render(f5);
/* 214 */     this.leftleg.render(f5);
/* 215 */     this.Shape16.render(f5);
/* 216 */     this.Shape17.render(f5);
/* 217 */     this.leftleg2.render(f5);
/* 218 */     this.leftleg3.render(f5);
/* 219 */     this.leftleg4.render(f5);
/*     */ 
/*     */ 
/*     */     
/* 223 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 230 */     model.rotateAngleX = x;
/* 231 */     model.rotateAngleY = y;
/* 232 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 237 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\model\ModelCryolophosaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */