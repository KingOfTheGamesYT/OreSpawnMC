/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Camarasaurus;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelCamarasaurus
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Body1;
/*     */   
/*     */   ModelRenderer Body2;
/*     */   
/*     */   ModelRenderer Body3;
/*     */   ModelRenderer Body4;
/*     */   ModelRenderer Tail0;
/*     */   ModelRenderer Neck1;
/*     */   ModelRenderer Neck2;
/*     */   ModelRenderer Neck3;
/*     */   ModelRenderer Head1;
/*     */   ModelRenderer Head2;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail3;
/*     */   ModelRenderer BLegupleft;
/*     */   ModelRenderer FLegupleft;
/*     */   ModelRenderer BLegupright;
/*     */   ModelRenderer FLegupright;
/*     */   ModelRenderer BLegdownright;
/*     */   ModelRenderer FLegdownleft;
/*     */   ModelRenderer FLegdownright;
/*     */   ModelRenderer BLegdownleft;
/*     */   
/*     */   public ModelCamarasaurus(float f1) {
/*  41 */     this.wingspeed = f1;
/*     */     
/*  43 */     this.textureWidth = 256;
/*  44 */     this.textureHeight = 256;
/*     */     
/*  46 */     this.Body1 = new ModelRenderer(this, 0, 135);
/*  47 */     this.Body1.addBox(-6.0F, 0.0F, 0.0F, 12, 12, 12);
/*  48 */     this.Body1.setRotationPoint(0.0F, -1.0F, 0.0F);
/*  49 */     this.Body1.setTextureSize(256, 256);
/*  50 */     this.Body1.mirror = true;
/*  51 */     setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
/*  52 */     this.Body2 = new ModelRenderer(this, 0, 160);
/*  53 */     this.Body2.addBox(-5.0F, 0.0F, 0.0F, 10, 10, 6);
/*  54 */     this.Body2.setRotationPoint(0.0F, -2.0F, -4.0F);
/*  55 */     this.Body2.setTextureSize(256, 256);
/*  56 */     this.Body2.mirror = true;
/*  57 */     setRotation(this.Body2, -0.1858931F, 0.0F, 0.0F);
/*  58 */     this.Body3 = new ModelRenderer(this, 0, 177);
/*  59 */     this.Body3.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 4);
/*  60 */     this.Body3.setRotationPoint(0.0F, -3.0F, -6.0F);
/*  61 */     this.Body3.setTextureSize(256, 256);
/*  62 */     this.Body3.mirror = true;
/*  63 */     setRotation(this.Body3, -0.3346075F, 0.0F, 0.0F);
/*  64 */     this.Body4 = new ModelRenderer(this, 0, 120);
/*  65 */     this.Body4.addBox(-5.0F, 0.0F, 0.0F, 10, 10, 4);
/*  66 */     this.Body4.setRotationPoint(0.0F, 0.0F, 11.0F);
/*  67 */     this.Body4.setTextureSize(256, 256);
/*  68 */     this.Body4.mirror = true;
/*  69 */     setRotation(this.Body4, 0.0F, 0.0F, 0.0F);
/*  70 */     this.Tail0 = new ModelRenderer(this, 0, 107);
/*  71 */     this.Tail0.addBox(-3.0F, -2.0F, 0.0F, 6, 6, 6);
/*  72 */     this.Tail0.setRotationPoint(0.0F, 3.0F, 14.0F);
/*  73 */     this.Tail0.setTextureSize(256, 256);
/*  74 */     this.Tail0.mirror = true;
/*  75 */     setRotation(this.Tail0, -0.0743572F, 0.0F, 0.0F);
/*  76 */     this.Neck1 = new ModelRenderer(this, 0, 190);
/*  77 */     this.Neck1.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 5);
/*  78 */     this.Neck1.setRotationPoint(0.0F, -4.0F, -9.0F);
/*  79 */     this.Neck1.setTextureSize(256, 256);
/*  80 */     this.Neck1.mirror = true;
/*  81 */     setRotation(this.Neck1, -0.4089647F, 0.0F, 0.0F);
/*  82 */     this.Neck2 = new ModelRenderer(this, 0, 202);
/*  83 */     this.Neck2.addBox(-2.0F, 0.0F, -6.0F, 4, 4, 7);
/*  84 */     this.Neck2.setRotationPoint(0.0F, -3.0F, -9.0F);
/*  85 */     this.Neck2.setTextureSize(256, 256);
/*  86 */     this.Neck2.mirror = true;
/*  87 */     setRotation(this.Neck2, -0.5948578F, 0.0F, 0.0F);
/*  88 */     this.Neck3 = new ModelRenderer(this, 0, 214);
/*  89 */     this.Neck3.addBox(-2.0F, -2.0F, -12.0F, 4, 4, 13);
/*  90 */     this.Neck3.setRotationPoint(0.0F, -5.0F, -15.0F);
/*  91 */     this.Neck3.setTextureSize(256, 256);
/*  92 */     this.Neck3.mirror = true;
/*  93 */     setRotation(this.Neck3, -0.8179294F, 0.0F, 0.0F);
/*  94 */     this.Head1 = new ModelRenderer(this, 0, 232);
/*  95 */     this.Head1.addBox(-4.0F, -3.0F, -6.0F, 8, 6, 6);
/*  96 */     this.Head1.setRotationPoint(0.0F, -13.0F, -22.0F);
/*  97 */     this.Head1.setTextureSize(256, 256);
/*  98 */     this.Head1.mirror = true;
/*  99 */     setRotation(this.Head1, -0.1115358F, 0.0F, 0.0F);
/* 100 */     this.Head2 = new ModelRenderer(this, 0, 245);
/* 101 */     this.Head2.addBox(-3.0F, -2.0F, -4.0F, 6, 4, 4);
/* 102 */     this.Head2.setRotationPoint(0.0F, -13.0F, -27.0F);
/* 103 */     this.Head2.setTextureSize(256, 256);
/* 104 */     this.Head2.mirror = true;
/* 105 */     setRotation(this.Head2, 0.0F, 0.0F, 0.0F);
/* 106 */     this.Tail1 = new ModelRenderer(this, 0, 93);
/* 107 */     this.Tail1.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 9);
/* 108 */     this.Tail1.setRotationPoint(0.0F, 5.0F, 19.0F);
/* 109 */     this.Tail1.setTextureSize(256, 256);
/* 110 */     this.Tail1.mirror = true;
/* 111 */     setRotation(this.Tail1, -0.1115358F, 0.0F, 0.0F);
/* 112 */     this.Tail2 = new ModelRenderer(this, 0, 82);
/* 113 */     this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8);
/* 114 */     this.Tail2.setRotationPoint(0.0F, 4.0F, 26.0F);
/* 115 */     this.Tail2.setTextureSize(256, 256);
/* 116 */     this.Tail2.mirror = true;
/* 117 */     setRotation(this.Tail2, -0.0743572F, 0.0F, 0.0F);
/* 118 */     this.Tail3 = new ModelRenderer(this, 0, 73);
/* 119 */     this.Tail3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 7);
/* 120 */     this.Tail3.setRotationPoint(0.0F, 4.5F, 34.0F);
/* 121 */     this.Tail3.setTextureSize(256, 256);
/* 122 */     this.Tail3.mirror = true;
/* 123 */     setRotation(this.Tail3, -0.0371786F, 0.0F, 0.0F);
/* 124 */     this.BLegupleft = new ModelRenderer(this, 49, 157);
/* 125 */     this.BLegupleft.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6);
/* 126 */     this.BLegupleft.setRotationPoint(2.0F, 9.0F, 7.0F);
/* 127 */     this.BLegupleft.setTextureSize(256, 256);
/* 128 */     this.BLegupleft.mirror = true;
/* 129 */     setRotation(this.BLegupleft, -0.1487195F, 0.0F, 0.0F);
/* 130 */     this.FLegupleft = new ModelRenderer(this, 49, 141);
/* 131 */     this.FLegupleft.addBox(0.0F, 0.0F, -6.0F, 6, 9, 6);
/* 132 */     this.FLegupleft.setRotationPoint(2.0F, 8.0F, 2.0F);
/* 133 */     this.FLegupleft.setTextureSize(256, 256);
/* 134 */     this.FLegupleft.mirror = true;
/* 135 */     setRotation(this.FLegupleft, 0.0F, 0.0F, 0.0F);
/* 136 */     this.BLegupright = new ModelRenderer(this, 49, 126);
/* 137 */     this.BLegupright.addBox(-6.0F, 0.0F, 0.0F, 6, 8, 6);
/* 138 */     this.BLegupright.setRotationPoint(-2.0F, 9.0F, 7.0F);
/* 139 */     this.BLegupright.setTextureSize(256, 256);
/* 140 */     this.BLegupright.mirror = true;
/* 141 */     setRotation(this.BLegupright, -0.1487144F, 0.0F, 0.0F);
/* 142 */     this.FLegupright = new ModelRenderer(this, 49, 110);
/* 143 */     this.FLegupright.addBox(-6.0F, 0.0F, -6.0F, 6, 9, 6);
/* 144 */     this.FLegupright.setRotationPoint(-2.0F, 8.0F, 2.0F);
/* 145 */     this.FLegupright.setTextureSize(256, 256);
/* 146 */     this.FLegupright.mirror = true;
/* 147 */     setRotation(this.FLegupright, 0.0F, 0.0F, 0.0F);
/* 148 */     this.BLegdownright = new ModelRenderer(this, 115, 157);
/* 149 */     this.BLegdownright.addBox(-5.0F, 7.0F, -1.0F, 5, 8, 5);
/* 150 */     this.BLegdownright.setRotationPoint(-2.0F, 9.0F, 7.0F);
/* 151 */     this.BLegdownright.setTextureSize(256, 256);
/* 152 */     this.BLegdownright.mirror = true;
/* 153 */     setRotation(this.BLegdownright, 0.0F, 0.0F, 0.0F);
/* 154 */     this.FLegdownleft = new ModelRenderer(this, 94, 143);
/* 155 */     this.FLegdownleft.addBox(0.0F, 8.0F, -6.0F, 5, 8, 5);
/* 156 */     this.FLegdownleft.setRotationPoint(2.0F, 8.0F, 2.0F);
/* 157 */     this.FLegdownleft.setTextureSize(256, 256);
/* 158 */     this.FLegdownleft.mirror = true;
/* 159 */     setRotation(this.FLegdownleft, 0.0F, 0.0F, 0.0F);
/* 160 */     this.FLegdownright = new ModelRenderer(this, 94, 157);
/* 161 */     this.FLegdownright.addBox(-5.0F, 8.0F, -6.0F, 5, 8, 5);
/* 162 */     this.FLegdownright.setRotationPoint(-2.0F, 8.0F, 2.0F);
/* 163 */     this.FLegdownright.setTextureSize(256, 256);
/* 164 */     this.FLegdownright.mirror = true;
/* 165 */     setRotation(this.FLegdownright, 0.0F, 0.0F, 0.0F);
/* 166 */     this.BLegdownleft = new ModelRenderer(this, 115, 143);
/* 167 */     this.BLegdownleft.addBox(0.0F, 7.0F, -1.0F, 5, 8, 5);
/* 168 */     this.BLegdownleft.setRotationPoint(2.0F, 9.0F, 7.0F);
/* 169 */     this.BLegdownleft.setTextureSize(256, 256);
/* 170 */     this.BLegdownleft.mirror = true;
/* 171 */     setRotation(this.BLegdownleft, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 179 */     Camarasaurus c = (Camarasaurus)entity;
/* 180 */     float hf = 0.0F;
/* 181 */     float newangle = 0.0F;
/*     */     
/* 183 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 184 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 187 */     if (f1 > 0.1D) {
/* 188 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 190 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 194 */     this.FLegupleft.rotateAngleX = newangle;
/* 195 */     this.FLegdownleft.rotateAngleX = newangle;
/* 196 */     this.FLegupright.rotateAngleX = -newangle;
/* 197 */     this.FLegdownright.rotateAngleX = -newangle;
/* 198 */     this.BLegupleft.rotateAngleX = -0.15F - newangle;
/* 199 */     this.BLegdownleft.rotateAngleX = -newangle;
/* 200 */     this.BLegupright.rotateAngleX = -0.15F + newangle;
/* 201 */     this.BLegdownright.rotateAngleX = newangle;
/*     */ 
/*     */     
/* 204 */     hf = c.getCamarasaurusHealth() / c.getMaxHealth();
/* 205 */     newangle = MathHelper.cos(f2 * 0.8F * this.wingspeed * hf) * 3.1415927F * 0.25F * hf;
/* 206 */     if (c.isSitting() == true) {
/* 207 */       newangle = 0.0F;
/*     */     }
/* 209 */     this.Tail0.rotateAngleY = newangle * 0.25F;
/* 210 */     this.Tail0.rotationPointZ += (float)Math.cos(this.Tail0.rotateAngleY) * 5.0F;
/* 211 */     this.Tail0.rotationPointX += (float)Math.sin(this.Tail0.rotateAngleY) * 5.0F;
/* 212 */     this.Tail1.rotateAngleY = newangle * 0.5F;
/* 213 */     this.Tail1.rotationPointZ += (float)Math.cos(this.Tail1.rotateAngleY) * 8.0F;
/* 214 */     this.Tail1.rotationPointX += (float)Math.sin(this.Tail1.rotateAngleY) * 8.0F;
/* 215 */     this.Tail2.rotateAngleY = newangle * 0.75F;
/* 216 */     this.Tail2.rotationPointZ += (float)Math.cos(this.Tail2.rotateAngleY) * 7.0F;
/* 217 */     this.Tail2.rotationPointX += (float)Math.sin(this.Tail2.rotateAngleY) * 7.0F;
/* 218 */     this.Tail3.rotateAngleY = newangle * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 222 */     this.Neck1.rotateAngleY = (float)Math.toRadians(f3) * 0.125F;
/* 223 */     this.Neck2.rotationPointZ = this.Neck1.rotationPointZ;
/* 224 */     this.Neck2.rotationPointX = this.Neck1.rotationPointX;
/* 225 */     this.Neck2.rotateAngleY = (float)Math.toRadians(f3) * 0.25F;
/* 226 */     this.Neck2.rotationPointZ -= (float)Math.cos(this.Neck2.rotateAngleY) * 6.0F;
/* 227 */     this.Neck2.rotationPointX -= (float)Math.sin(this.Neck2.rotateAngleY) * 6.0F;
/* 228 */     this.Neck3.rotateAngleY = (float)Math.toRadians(f3) * 0.38F;
/* 229 */     this.Neck3.rotationPointZ -= (float)Math.cos(this.Neck3.rotateAngleY) * 7.0F;
/* 230 */     this.Neck3.rotationPointX -= (float)Math.sin(this.Neck3.rotateAngleY) * 7.0F;
/* 231 */     this.Head1.rotateAngleY = (float)Math.toRadians(f3);
/* 232 */     this.Head1.rotationPointZ -= (float)Math.cos(this.Head1.rotateAngleY) * 5.0F;
/* 233 */     this.Head1.rotationPointX -= (float)Math.sin(this.Head1.rotateAngleY) * 5.0F;
/* 234 */     this.Head2.rotateAngleY = (float)Math.toRadians(f3);
/*     */     
/* 236 */     if (this.isChild) {
/* 237 */       GL11.glPushMatrix();
/*     */       
/* 239 */       GL11.glTranslatef(0.0F, 0.9F, 0.0F);
/*     */       
/* 241 */       GL11.glScalef(0.4F, 0.4F, 0.4F);
/*     */       
/* 243 */       this.Body1.render(f5);
/* 244 */       this.Body2.render(f5);
/* 245 */       this.Body3.render(f5);
/* 246 */       this.Body4.render(f5);
/* 247 */       this.Tail0.render(f5);
/* 248 */       this.Neck1.render(f5);
/* 249 */       this.Neck2.render(f5);
/* 250 */       this.Neck3.render(f5);
/* 251 */       this.Head1.render(f5);
/* 252 */       this.Head2.render(f5);
/* 253 */       this.Tail1.render(f5);
/* 254 */       this.Tail2.render(f5);
/* 255 */       this.Tail3.render(f5);
/*     */       
/* 257 */       this.FLegupleft.render(f5);
/* 258 */       this.FLegdownleft.render(f5);
/* 259 */       this.FLegupright.render(f5);
/* 260 */       this.FLegdownright.render(f5);
/* 261 */       this.BLegupleft.render(f5);
/* 262 */       this.BLegdownright.render(f5);
/* 263 */       this.BLegupright.render(f5);
/* 264 */       this.BLegdownleft.render(f5);
/*     */ 
/*     */ 
/*     */       
/* 268 */       GL11.glPopMatrix();
/*     */     } else {
/*     */       
/* 271 */       GL11.glPushMatrix();
/*     */       
/* 273 */       GL11.glTranslatef(0.0F, 0.45000005F, 0.0F);
/*     */       
/* 275 */       GL11.glScalef(0.7F, 0.7F, 0.7F);
/*     */       
/* 277 */       this.Body1.render(f5);
/* 278 */       this.Body2.render(f5);
/* 279 */       this.Body3.render(f5);
/* 280 */       this.Body4.render(f5);
/* 281 */       this.Tail0.render(f5);
/* 282 */       this.Neck1.render(f5);
/* 283 */       this.Neck2.render(f5);
/* 284 */       this.Neck3.render(f5);
/* 285 */       this.Head1.render(f5);
/* 286 */       this.Head2.render(f5);
/* 287 */       this.Tail1.render(f5);
/* 288 */       this.Tail2.render(f5);
/* 289 */       this.Tail3.render(f5);
/*     */       
/* 291 */       this.FLegupleft.render(f5);
/* 292 */       this.FLegdownleft.render(f5);
/* 293 */       this.FLegupright.render(f5);
/* 294 */       this.FLegdownright.render(f5);
/* 295 */       this.BLegupleft.render(f5);
/* 296 */       this.BLegdownright.render(f5);
/* 297 */       this.BLegupright.render(f5);
/* 298 */       this.BLegdownleft.render(f5);
/*     */       
/* 300 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 307 */     model.rotateAngleX = x;
/* 308 */     model.rotateAngleY = y;
/* 309 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 314 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.1-deobf.jar!\danger\orespawn\entity\model\ModelCamarasaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */