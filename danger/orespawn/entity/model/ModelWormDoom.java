/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.WormDoom;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelWormDoom
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer head1;
/*     */   ModelRenderer tooth1;
/*     */   ModelRenderer tooth2;
/*     */   ModelRenderer tooth3;
/*     */   ModelRenderer tooth4;
/*     */   ModelRenderer tooth5;
/*     */   ModelRenderer tooth6;
/*     */   ModelRenderer tooth7;
/*     */   ModelRenderer tooth8;
/*     */   ModelRenderer head2;
/*     */   ModelRenderer body1;
/*     */   ModelRenderer body2;
/*  29 */   float worm_scale = 2.0F;
/*     */ 
/*     */   
/*     */   public ModelWormDoom() {
/*  33 */     this.textureWidth = 64;
/*  34 */     this.textureHeight = 256;
/*  35 */     this.head1 = new ModelRenderer(this, 0, 0);
/*  36 */     this.head1.addBox(-8.0F, -8.0F, -6.0F, 16, 16, 12);
/*  37 */     this.head1.setRotationPoint(0.0F, 12.0F, 0.0F);
/*  38 */     this.head1.setTextureSize(64, 256);
/*  39 */     this.head1.mirror = true;
/*  40 */     setRotation(this.head1, 0.0F, 0.0F, 0.0F);
/*  41 */     this.tooth1 = new ModelRenderer(this, 0, 220);
/*  42 */     this.tooth1.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  43 */     this.tooth1.setRotationPoint(0.0F, 21.0F, -6.0F);
/*  44 */     this.tooth1.setTextureSize(64, 256);
/*  45 */     this.tooth1.mirror = true;
/*  46 */     setRotation(this.tooth1, 0.0F, 0.0F, 0.0F);
/*  47 */     this.tooth2 = new ModelRenderer(this, 0, 210);
/*  48 */     this.tooth2.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  49 */     this.tooth2.setRotationPoint(0.0F, 3.0F, -6.0F);
/*  50 */     this.tooth2.setTextureSize(64, 256);
/*  51 */     this.tooth2.mirror = true;
/*  52 */     setRotation(this.tooth2, 0.0F, 0.0F, 0.0F);
/*  53 */     this.tooth3 = new ModelRenderer(this, 0, 200);
/*  54 */     this.tooth3.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  55 */     this.tooth3.setRotationPoint(9.0F, 12.0F, -6.0F);
/*  56 */     this.tooth3.setTextureSize(64, 256);
/*  57 */     this.tooth3.mirror = true;
/*  58 */     setRotation(this.tooth3, 0.0F, 0.0F, 0.0F);
/*  59 */     this.tooth4 = new ModelRenderer(this, 0, 190);
/*  60 */     this.tooth4.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  61 */     this.tooth4.setRotationPoint(-9.0F, 12.0F, -6.0F);
/*  62 */     this.tooth4.setTextureSize(64, 256);
/*  63 */     this.tooth4.mirror = true;
/*  64 */     setRotation(this.tooth4, 0.0F, 0.0F, 0.0F);
/*  65 */     this.tooth5 = new ModelRenderer(this, 0, 180);
/*  66 */     this.tooth5.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  67 */     this.tooth5.setRotationPoint(-6.0F, 6.0F, -6.0F);
/*  68 */     this.tooth5.setTextureSize(64, 256);
/*  69 */     this.tooth5.mirror = true;
/*  70 */     setRotation(this.tooth5, 0.0F, 0.0F, 0.0F);
/*  71 */     this.tooth6 = new ModelRenderer(this, 0, 170);
/*  72 */     this.tooth6.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  73 */     this.tooth6.setRotationPoint(6.0F, 18.0F, -6.0F);
/*  74 */     this.tooth6.setTextureSize(64, 256);
/*  75 */     this.tooth6.mirror = true;
/*  76 */     setRotation(this.tooth6, 0.0F, 0.0F, 0.0F);
/*  77 */     this.tooth7 = new ModelRenderer(this, 0, 160);
/*  78 */     this.tooth7.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  79 */     this.tooth7.setRotationPoint(6.0F, 6.0F, -6.0F);
/*  80 */     this.tooth7.setTextureSize(64, 256);
/*  81 */     this.tooth7.mirror = true;
/*  82 */     setRotation(this.tooth7, 0.0F, 0.0F, 0.0F);
/*  83 */     this.tooth8 = new ModelRenderer(this, 0, 150);
/*  84 */     this.tooth8.addBox(-0.5F, -0.5F, -7.0F, 1, 1, 7);
/*  85 */     this.tooth8.setRotationPoint(-6.0F, 18.0F, -6.0F);
/*  86 */     this.tooth8.setTextureSize(64, 256);
/*  87 */     this.tooth8.mirror = true;
/*  88 */     setRotation(this.tooth8, 0.0F, 0.0F, 0.0F);
/*  89 */     this.head2 = new ModelRenderer(this, 0, 31);
/*  90 */     this.head2.addBox(-8.0F, -8.0F, -6.0F, 16, 16, 12);
/*  91 */     this.head2.setRotationPoint(0.0F, 12.0F, 0.0F);
/*  92 */     this.head2.setTextureSize(64, 256);
/*  93 */     this.head2.mirror = true;
/*  94 */     setRotation(this.head2, 0.0F, 0.0F, 0.7853982F);
/*  95 */     this.body1 = new ModelRenderer(this, 0, 82);
/*  96 */     this.body1.addBox(-8.0F, -8.0F, -6.0F, 16, 16, 12);
/*  97 */     this.body1.setRotationPoint(0.0F, 12.0F, 4.0F);
/*  98 */     this.body1.setTextureSize(64, 256);
/*  99 */     this.body1.mirror = true;
/* 100 */     setRotation(this.body1, 0.0F, 0.0F, 0.0F);
/* 101 */     this.body2 = new ModelRenderer(this, 0, 114);
/* 102 */     this.body2.addBox(-8.0F, -8.0F, -6.0F, 16, 16, 12);
/* 103 */     this.body2.setRotationPoint(0.0F, 12.0F, 4.0F);
/* 104 */     this.body2.setTextureSize(64, 256);
/* 105 */     this.body2.mirror = true;
/* 106 */     setRotation(this.body2, 0.0F, 0.0F, 0.7853982F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
/* 122 */     GL11.glPushMatrix();
/* 123 */     if (!entity.world.isRemote)
/* 124 */       return;  if (!(entity instanceof WormDoom))
/* 125 */       return;  WormDoom dw = (WormDoom)entity;
/* 126 */     float newangle = 0.0F;
/* 127 */     float newangle2 = 0.0F;
/*     */     
/* 129 */     double dist = 32.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     dist = 6.0D;
/* 139 */     double d1 = (float)(Math.cos(newangle) * dist);
/* 140 */     double d2 = (float)(Math.sin(newangle) * dist);
/* 141 */     this.tooth1.rotationPointZ = (float)(this.head1.rotationPointZ - d1);
/* 142 */     double d3 = (float)(Math.sin(newangle2) * d1);
/*     */     
/* 144 */     this.tooth1.rotationPointX = (float)(this.head1.rotationPointX - d3);
/* 145 */     this.tooth1.rotationPointY = (float)(this.head1.rotationPointY + d2 - 9.0D);
/*     */     
/* 147 */     this.tooth2.rotationPointZ = this.tooth1.rotationPointZ;
/* 148 */     this.tooth2.rotationPointX = this.tooth1.rotationPointX;
/* 149 */     this.tooth1.rotationPointY += 18.0F;
/*     */     
/* 151 */     this.tooth3.rotationPointZ = this.tooth1.rotationPointZ;
/* 152 */     this.tooth1.rotationPointX += 9.0F;
/* 153 */     this.tooth1.rotationPointY += 9.0F;
/*     */     
/* 155 */     this.tooth4.rotationPointZ = this.tooth1.rotationPointZ;
/* 156 */     this.tooth1.rotationPointX -= 9.0F;
/* 157 */     this.tooth1.rotationPointY += 9.0F;
/*     */     
/* 159 */     this.tooth5.rotationPointZ = this.tooth1.rotationPointZ;
/* 160 */     this.tooth1.rotationPointX -= 6.0F;
/* 161 */     this.tooth5.rotationPointY = this.tooth1.rotationPointY + 9.0F - 6.0F;
/*     */     
/* 163 */     this.tooth6.rotationPointZ = this.tooth1.rotationPointZ;
/* 164 */     this.tooth1.rotationPointX += 6.0F;
/* 165 */     this.tooth6.rotationPointY = this.tooth1.rotationPointY + 9.0F + 6.0F;
/*     */     
/* 167 */     this.tooth7.rotationPointZ = this.tooth1.rotationPointZ;
/* 168 */     this.tooth1.rotationPointX += 6.0F;
/* 169 */     this.tooth7.rotationPointY = this.tooth1.rotationPointY + 9.0F - 6.0F;
/*     */     
/* 171 */     this.tooth8.rotationPointZ = this.tooth1.rotationPointZ;
/* 172 */     this.tooth1.rotationPointX -= 6.0F;
/* 173 */     this.tooth8.rotationPointY = this.tooth1.rotationPointY + 9.0F + 6.0F;
/*     */     
/* 175 */     this.tooth1.rotationPointZ = (float)(this.tooth1.rotationPointZ - Math.sin(this.head1.rotateAngleX) * 9.0D);
/* 176 */     this.tooth2.rotationPointZ = (float)(this.tooth2.rotationPointZ + Math.sin(this.head1.rotateAngleX) * 9.0D);
/*     */     
/* 178 */     this.tooth3.rotationPointZ = (float)(this.tooth3.rotationPointZ - Math.sin(this.head1.rotateAngleY) * 9.0D);
/* 179 */     this.tooth4.rotationPointZ = (float)(this.tooth4.rotationPointZ + Math.sin(this.head1.rotateAngleY) * 9.0D);
/*     */     
/* 181 */     this.tooth7.rotationPointZ = (float)(this.tooth7.rotationPointZ - Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 182 */     this.tooth7.rotationPointZ = (float)(this.tooth7.rotationPointZ - Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 184 */     this.tooth6.rotationPointZ = (float)(this.tooth6.rotationPointZ + Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 185 */     this.tooth6.rotationPointZ = (float)(this.tooth6.rotationPointZ - Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 187 */     this.tooth5.rotationPointZ = (float)(this.tooth5.rotationPointZ - Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 188 */     this.tooth5.rotationPointZ = (float)(this.tooth5.rotationPointZ + Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 190 */     this.tooth8.rotationPointZ = (float)(this.tooth8.rotationPointZ + Math.sin(this.head1.rotateAngleX) * 6.0D);
/* 191 */     this.tooth8.rotationPointZ = (float)(this.tooth8.rotationPointZ + Math.sin(this.head1.rotateAngleY) * 6.0D);
/*     */     
/* 193 */     newangle = (float)Math.cos(Math.toRadians((f * 5.7F))) * 3.1415927F * 0.35F;
/*     */     
/* 195 */     this.head1.rotateAngleX += newangle;
/* 196 */     this.head1.rotateAngleX -= newangle;
/* 197 */     this.head1.rotateAngleY += newangle;
/* 198 */     this.head1.rotateAngleY -= newangle;
/*     */     
/* 200 */     this.head1.rotateAngleX += newangle;
/* 201 */     this.head1.rotateAngleX += newangle;
/* 202 */     this.head1.rotateAngleX -= newangle;
/* 203 */     this.head1.rotateAngleX -= newangle;
/*     */     
/* 205 */     this.head1.rotateAngleY += newangle;
/* 206 */     this.head1.rotateAngleY += newangle;
/* 207 */     this.head1.rotateAngleY -= newangle;
/* 208 */     this.head1.rotateAngleY -= newangle;
/*     */     
/* 210 */     GL11.glPushMatrix();
/*     */     
/* 212 */     GL11.glScalef(this.worm_scale, this.worm_scale, this.worm_scale);
/*     */     
/* 214 */     GL11.glRotatef(dw.rotationYaw, 0.0F, 1.0F, 0.0F);
/* 215 */     GL11.glRotatef(dw.rotationPitch, 1.0F, 0.0F, 0.0F);
/* 216 */     this.head1.render(scale);
/* 217 */     this.head2.render(scale);
/* 218 */     this.tooth1.render(scale);
/* 219 */     this.tooth2.render(scale);
/* 220 */     this.tooth3.render(scale);
/* 221 */     this.tooth4.render(scale);
/* 222 */     this.tooth5.render(scale);
/* 223 */     this.tooth6.render(scale);
/* 224 */     this.tooth7.render(scale);
/* 225 */     this.tooth8.render(scale);
/*     */     
/* 227 */     GL11.glPopMatrix();
/* 228 */     for (int i = 0; i < 100; i++) {
/* 229 */       double dx = dw.lposx[0] - dw.lposx[i];
/* 230 */       double dy = dw.lposy[0] - dw.lposy[i];
/* 231 */       double dz = dw.lposz[0] - dw.lposz[i];
/*     */       
/* 233 */       GL11.glPushMatrix();
/*     */       
/* 235 */       GL11.glTranslated(dx, dy, dz);
/*     */       
/* 237 */       if (dw.rotyaw[i] != 0.0D) GL11.glRotated(dw.rotyaw[i], 0.0D, 1.0D, 0.0D); 
/* 238 */       if (dw.rotpitch[i] != 0.0D) GL11.glRotated(dw.rotpitch[i], 1.0D, 0.0D, 0.0D);
/*     */ 
/*     */       
/* 241 */       double scale1 = 1.0D;
/* 242 */       if (i > 25) scale1 = (75.0D - (i - 25)) / 75.0D; 
/* 243 */       scale1 *= 2.0D - Math.cos(Math.toRadians((i * 3)));
/* 244 */       if (scale1 < 0.009999999776482582D) scale1 = 0.009999999776482582D; 
/* 245 */       GL11.glScaled(scale1 * this.worm_scale, scale1 * this.worm_scale, (1.5F * this.worm_scale));
/*     */       
/* 247 */       this.body1.render(scale);
/* 248 */       this.body2.render(scale);
/*     */       
/* 250 */       if (i > 75) {
/*     */ 
/*     */         
/* 253 */         GL11.glTranslatef(0.0F, 1.0F / this.worm_scale, 0.0F);
/* 254 */         this.body1.render(scale);
/* 255 */         this.body2.render(scale);
/*     */       } 
/*     */ 
/*     */       
/* 259 */       GL11.glPopMatrix();
/*     */     } 
/* 261 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 265 */     model.rotateAngleX = x;
/* 266 */     model.rotateAngleY = y;
/* 267 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelWormDoom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */