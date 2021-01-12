/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelChainsaw
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer engine;
/*     */   ModelRenderer handle1;
/*     */   ModelRenderer handle2;
/*     */   ModelRenderer handle3;
/*     */   ModelRenderer muffler;
/*     */   ModelRenderer blade1;
/*     */   ModelRenderer blade2;
/*     */   ModelRenderer tooth;
/*  20 */   float toothpos = 0.0F;
/*  21 */   int toothdir = 0;
/*  22 */   float toothpos1 = 7.0F;
/*  23 */   int toothdir1 = 0;
/*  24 */   float toothpos2 = 14.0F;
/*  25 */   int toothdir2 = 0;
/*  26 */   float toothpos3 = 20.0F;
/*  27 */   int toothdir3 = 1;
/*  28 */   float toothpos4 = 13.0F;
/*  29 */   int toothdir4 = 1;
/*  30 */   float toothpos5 = 6.0F;
/*  31 */   int toothdir5 = 1;
/*     */ 
/*     */   
/*     */   public ModelChainsaw() {
/*  35 */     this.textureWidth = 64;
/*  36 */     this.textureHeight = 64;
/*     */     
/*  38 */     this.engine = new ModelRenderer(this, 0, 19);
/*  39 */     this.engine.addBox(-2.0F, -4.0F, -4.0F, 4, 7, 8);
/*  40 */     this.engine.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  41 */     this.engine.setTextureSize(64, 64);
/*  42 */     this.engine.mirror = true;
/*  43 */     setRotation(this.engine, 0.0F, 0.0F, 0.0F);
/*  44 */     this.handle1 = new ModelRenderer(this, 49, 0);
/*  45 */     this.handle1.addBox(0.0F, -3.0F, 3.0F, 1, 1, 5);
/*  46 */     this.handle1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  47 */     this.handle1.setTextureSize(64, 64);
/*  48 */     this.handle1.mirror = true;
/*  49 */     setRotation(this.handle1, -0.1919862F, 0.0F, 0.0F);
/*  50 */     this.handle2 = new ModelRenderer(this, 50, 13);
/*  51 */     this.handle2.addBox(0.0F, 2.0F, 4.0F, 1, 1, 4);
/*  52 */     this.handle2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  53 */     this.handle2.setTextureSize(64, 64);
/*  54 */     this.handle2.mirror = true;
/*  55 */     setRotation(this.handle2, 0.0F, 0.0F, 0.0F);
/*  56 */     this.handle3 = new ModelRenderer(this, 52, 7);
/*  57 */     this.handle3.addBox(0.0F, -2.0F, 7.0F, 1, 4, 1);
/*  58 */     this.handle3.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  59 */     this.handle3.setTextureSize(64, 64);
/*  60 */     this.handle3.mirror = true;
/*  61 */     setRotation(this.handle3, -0.0872665F, 0.0F, 0.0F);
/*  62 */     this.muffler = new ModelRenderer(this, 14, 0);
/*  63 */     this.muffler.addBox(-3.0F, 0.0F, 1.0F, 1, 3, 3);
/*  64 */     this.muffler.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  65 */     this.muffler.setTextureSize(64, 64);
/*  66 */     this.muffler.mirror = true;
/*  67 */     setRotation(this.muffler, 0.0F, 0.0F, 0.0F);
/*  68 */     this.blade1 = new ModelRenderer(this, 0, 35);
/*  69 */     this.blade1.addBox(0.0F, -2.0F, -28.0F, 1, 4, 24);
/*  70 */     this.blade1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  71 */     this.blade1.setTextureSize(64, 64);
/*  72 */     this.blade1.mirror = true;
/*  73 */     setRotation(this.blade1, 0.0F, 0.0F, 0.0F);
/*  74 */     this.blade2 = new ModelRenderer(this, 0, 8);
/*  75 */     this.blade2.addBox(0.0F, -2.5F, -2.5F, 1, 5, 5);
/*  76 */     this.blade2.setRotationPoint(0.0F, 0.0F, -28.0F);
/*  77 */     this.blade2.setTextureSize(64, 64);
/*  78 */     this.blade2.mirror = true;
/*  79 */     setRotation(this.blade2, 0.0F, 0.0F, 0.0F);
/*  80 */     this.tooth = new ModelRenderer(this, 0, 0);
/*  81 */     this.tooth.addBox(0.0F, -1.0F, -0.5F, 1, 1, 1);
/*  82 */     this.tooth.setRotationPoint(0.0F, -2.0F, -5.0F);
/*  83 */     this.tooth.setTextureSize(64, 64);
/*  84 */     this.tooth.mirror = true;
/*  85 */     setRotation(this.tooth, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/*  90 */     float f5 = 1.0F;
/*     */     
/*  92 */     renderTooth(f5);
/*  93 */     renderTooth1(f5);
/*  94 */     renderTooth2(f5);
/*  95 */     renderTooth3(f5);
/*  96 */     renderTooth4(f5);
/*  97 */     renderTooth5(f5);
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.blade2.rotateAngleX = (float)(this.blade2.rotateAngleX + 0.10471975511965977D);
/* 102 */     if (this.blade2.rotateAngleX > 6.283185307179586D) this.blade2.rotateAngleX = 0.0F;
/*     */     
/* 104 */     this.engine.render(f5);
/* 105 */     this.handle1.render(f5);
/* 106 */     this.handle2.render(f5);
/* 107 */     this.handle3.render(f5);
/* 108 */     this.muffler.render(f5);
/* 109 */     this.blade1.render(f5);
/* 110 */     this.blade2.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 116 */     model.rotateAngleX = x;
/* 117 */     model.rotateAngleY = y;
/* 118 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderTooth(float f5) {
/* 123 */     if (this.toothdir == 0) {
/* 124 */       this.tooth.rotationPointY = -2.0F;
/* 125 */       this.tooth.rotationPointZ = -5.0F - this.toothpos;
/* 126 */       this.toothpos += 0.5F;
/* 127 */       if (this.toothpos > 21.0F) {
/* 128 */         this.toothpos = 21.0F;
/* 129 */         this.toothdir = 1;
/*     */       } 
/*     */     } else {
/* 132 */       this.tooth.rotationPointY = 3.0F;
/* 133 */       this.tooth.rotationPointZ = -5.0F - this.toothpos;
/* 134 */       this.toothpos -= 0.5F;
/* 135 */       if (this.toothpos < 0.0F) {
/* 136 */         this.toothpos = 0.0F;
/* 137 */         this.toothdir = 0;
/*     */       } 
/*     */     } 
/* 140 */     this.tooth.render(f5);
/*     */   }
/*     */   
/*     */   private void renderTooth1(float f5) {
/* 144 */     if (this.toothdir1 == 0) {
/* 145 */       this.tooth.rotationPointY = -2.0F;
/* 146 */       this.tooth.rotationPointZ = -5.0F - this.toothpos1;
/* 147 */       this.toothpos1 += 0.5F;
/* 148 */       if (this.toothpos1 > 21.0F) {
/* 149 */         this.toothpos1 = 21.0F;
/* 150 */         this.toothdir1 = 1;
/*     */       } 
/*     */     } else {
/* 153 */       this.tooth.rotationPointY = 3.0F;
/* 154 */       this.tooth.rotationPointZ = -5.0F - this.toothpos1;
/* 155 */       this.toothpos1 -= 0.5F;
/* 156 */       if (this.toothpos1 < 0.0F) {
/* 157 */         this.toothpos1 = 0.0F;
/* 158 */         this.toothdir1 = 0;
/*     */       } 
/*     */     } 
/* 161 */     this.tooth.render(f5);
/*     */   }
/*     */   
/*     */   private void renderTooth2(float f5) {
/* 165 */     if (this.toothdir2 == 0) {
/* 166 */       this.tooth.rotationPointY = -2.0F;
/* 167 */       this.tooth.rotationPointZ = -5.0F - this.toothpos2;
/* 168 */       this.toothpos2 += 0.5F;
/* 169 */       if (this.toothpos2 > 21.0F) {
/* 170 */         this.toothpos2 = 21.0F;
/* 171 */         this.toothdir2 = 1;
/*     */       } 
/*     */     } else {
/* 174 */       this.tooth.rotationPointY = 3.0F;
/* 175 */       this.tooth.rotationPointZ = -5.0F - this.toothpos2;
/* 176 */       this.toothpos2 -= 0.5F;
/* 177 */       if (this.toothpos2 < 0.0F) {
/* 178 */         this.toothpos2 = 0.0F;
/* 179 */         this.toothdir2 = 0;
/*     */       } 
/*     */     } 
/* 182 */     this.tooth.render(f5);
/*     */   }
/*     */   
/*     */   private void renderTooth3(float f5) {
/* 186 */     if (this.toothdir3 == 0) {
/* 187 */       this.tooth.rotationPointY = -2.0F;
/* 188 */       this.tooth.rotationPointZ = -5.0F - this.toothpos3;
/* 189 */       this.toothpos3 += 0.5F;
/* 190 */       if (this.toothpos3 > 21.0F) {
/* 191 */         this.toothpos3 = 21.0F;
/* 192 */         this.toothdir3 = 1;
/*     */       } 
/*     */     } else {
/* 195 */       this.tooth.rotationPointY = 3.0F;
/* 196 */       this.tooth.rotationPointZ = -5.0F - this.toothpos3;
/* 197 */       this.toothpos3 -= 0.5F;
/* 198 */       if (this.toothpos3 < 0.0F) {
/* 199 */         this.toothpos3 = 0.0F;
/* 200 */         this.toothdir3 = 0;
/*     */       } 
/*     */     } 
/* 203 */     this.tooth.render(f5);
/*     */   }
/*     */   
/*     */   private void renderTooth4(float f5) {
/* 207 */     if (this.toothdir4 == 0) {
/* 208 */       this.tooth.rotationPointY = -2.0F;
/* 209 */       this.tooth.rotationPointZ = -5.0F - this.toothpos4;
/* 210 */       this.toothpos4 += 0.5F;
/* 211 */       if (this.toothpos4 > 21.0F) {
/* 212 */         this.toothpos4 = 21.0F;
/* 213 */         this.toothdir4 = 1;
/*     */       } 
/*     */     } else {
/* 216 */       this.tooth.rotationPointY = 3.0F;
/* 217 */       this.tooth.rotationPointZ = -5.0F - this.toothpos4;
/* 218 */       this.toothpos4 -= 0.5F;
/* 219 */       if (this.toothpos4 < 0.0F) {
/* 220 */         this.toothpos4 = 0.0F;
/* 221 */         this.toothdir4 = 0;
/*     */       } 
/*     */     } 
/* 224 */     this.tooth.render(f5);
/*     */   }
/*     */   
/*     */   private void renderTooth5(float f5) {
/* 228 */     if (this.toothdir5 == 0) {
/* 229 */       this.tooth.rotationPointY = -2.0F;
/* 230 */       this.tooth.rotationPointZ = -5.0F - this.toothpos5;
/* 231 */       this.toothpos5 += 0.5F;
/* 232 */       if (this.toothpos5 > 21.0F) {
/* 233 */         this.toothpos5 = 21.0F;
/* 234 */         this.toothdir5 = 1;
/*     */       } 
/*     */     } else {
/* 237 */       this.tooth.rotationPointY = 3.0F;
/* 238 */       this.tooth.rotationPointZ = -5.0F - this.toothpos5;
/* 239 */       this.toothpos5 -= 0.5F;
/* 240 */       if (this.toothpos5 < 0.0F) {
/* 241 */         this.toothpos5 = 0.0F;
/* 242 */         this.toothdir5 = 0;
/*     */       } 
/*     */     } 
/* 245 */     this.tooth.render(f5);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelChainsaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */