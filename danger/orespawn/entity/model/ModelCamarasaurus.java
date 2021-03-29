/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import danger.orespawn.entity.Camarasaurus;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelCamarasaurus
/*     */   extends ModelBase
/*     */ {
/*  13 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Body1;
/*     */   
/*     */   ModelRenderer Body2;
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
/*  39 */     this.wingspeed = f1;
/*     */     
/*  41 */     this.textureWidth = 256;
/*  42 */     this.textureHeight = 256;
/*     */     
/*  44 */     this.Body1 = new ModelRenderer(this, 0, 135);
/*  45 */     this.Body1.addBox(-6.0F, 0.0F, 0.0F, 12, 12, 12);
/*  46 */     this.Body1.setRotationPoint(0.0F, -1.0F, 0.0F);
/*  47 */     this.Body1.setTextureSize(256, 256);
/*  48 */     this.Body1.mirror = true;
/*  49 */     setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
/*  50 */     this.Body2 = new ModelRenderer(this, 0, 160);
/*  51 */     this.Body2.addBox(-5.0F, 0.0F, 0.0F, 10, 10, 6);
/*  52 */     this.Body2.setRotationPoint(0.0F, -2.0F, -4.0F);
/*  53 */     this.Body2.setTextureSize(256, 256);
/*  54 */     this.Body2.mirror = true;
/*  55 */     setRotation(this.Body2, -0.1858931F, 0.0F, 0.0F);
/*  56 */     this.Body3 = new ModelRenderer(this, 0, 177);
/*  57 */     this.Body3.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 4);
/*  58 */     this.Body3.setRotationPoint(0.0F, -3.0F, -6.0F);
/*  59 */     this.Body3.setTextureSize(256, 256);
/*  60 */     this.Body3.mirror = true;
/*  61 */     setRotation(this.Body3, -0.3346075F, 0.0F, 0.0F);
/*  62 */     this.Body4 = new ModelRenderer(this, 0, 120);
/*  63 */     this.Body4.addBox(-5.0F, 0.0F, 0.0F, 10, 10, 4);
/*  64 */     this.Body4.setRotationPoint(0.0F, 0.0F, 11.0F);
/*  65 */     this.Body4.setTextureSize(256, 256);
/*  66 */     this.Body4.mirror = true;
/*  67 */     setRotation(this.Body4, 0.0F, 0.0F, 0.0F);
/*  68 */     this.Tail0 = new ModelRenderer(this, 0, 107);
/*  69 */     this.Tail0.addBox(-3.0F, -2.0F, 0.0F, 6, 6, 6);
/*  70 */     this.Tail0.setRotationPoint(0.0F, 3.0F, 14.0F);
/*  71 */     this.Tail0.setTextureSize(256, 256);
/*  72 */     this.Tail0.mirror = true;
/*  73 */     setRotation(this.Tail0, -0.0743572F, 0.0F, 0.0F);
/*  74 */     this.Neck1 = new ModelRenderer(this, 0, 190);
/*  75 */     this.Neck1.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 5);
/*  76 */     this.Neck1.setRotationPoint(0.0F, -4.0F, -9.0F);
/*  77 */     this.Neck1.setTextureSize(256, 256);
/*  78 */     this.Neck1.mirror = true;
/*  79 */     setRotation(this.Neck1, -0.4089647F, 0.0F, 0.0F);
/*  80 */     this.Neck2 = new ModelRenderer(this, 0, 202);
/*  81 */     this.Neck2.addBox(-2.0F, 0.0F, -6.0F, 4, 4, 7);
/*  82 */     this.Neck2.setRotationPoint(0.0F, -3.0F, -9.0F);
/*  83 */     this.Neck2.setTextureSize(256, 256);
/*  84 */     this.Neck2.mirror = true;
/*  85 */     setRotation(this.Neck2, -0.5948578F, 0.0F, 0.0F);
/*  86 */     this.Neck3 = new ModelRenderer(this, 0, 214);
/*  87 */     this.Neck3.addBox(-2.0F, -2.0F, -12.0F, 4, 4, 13);
/*  88 */     this.Neck3.setRotationPoint(0.0F, -5.0F, -15.0F);
/*  89 */     this.Neck3.setTextureSize(256, 256);
/*  90 */     this.Neck3.mirror = true;
/*  91 */     setRotation(this.Neck3, -0.8179294F, 0.0F, 0.0F);
/*  92 */     this.Head1 = new ModelRenderer(this, 0, 232);
/*  93 */     this.Head1.addBox(-4.0F, -3.0F, -6.0F, 8, 6, 6);
/*  94 */     this.Head1.setRotationPoint(0.0F, -13.0F, -22.0F);
/*  95 */     this.Head1.setTextureSize(256, 256);
/*  96 */     this.Head1.mirror = true;
/*  97 */     setRotation(this.Head1, -0.1115358F, 0.0F, 0.0F);
/*  98 */     this.Head2 = new ModelRenderer(this, 0, 245);
/*  99 */     this.Head2.addBox(-3.0F, -2.0F, -4.0F, 6, 4, 4);
/* 100 */     this.Head2.setRotationPoint(0.0F, -13.0F, -27.0F);
/* 101 */     this.Head2.setTextureSize(256, 256);
/* 102 */     this.Head2.mirror = true;
/* 103 */     setRotation(this.Head2, 0.0F, 0.0F, 0.0F);
/* 104 */     this.Tail1 = new ModelRenderer(this, 0, 93);
/* 105 */     this.Tail1.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 9);
/* 106 */     this.Tail1.setRotationPoint(0.0F, 5.0F, 19.0F);
/* 107 */     this.Tail1.setTextureSize(256, 256);
/* 108 */     this.Tail1.mirror = true;
/* 109 */     setRotation(this.Tail1, -0.1115358F, 0.0F, 0.0F);
/* 110 */     this.Tail2 = new ModelRenderer(this, 0, 82);
/* 111 */     this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8);
/* 112 */     this.Tail2.setRotationPoint(0.0F, 4.0F, 26.0F);
/* 113 */     this.Tail2.setTextureSize(256, 256);
/* 114 */     this.Tail2.mirror = true;
/* 115 */     setRotation(this.Tail2, -0.0743572F, 0.0F, 0.0F);
/* 116 */     this.Tail3 = new ModelRenderer(this, 0, 73);
/* 117 */     this.Tail3.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 7);
/* 118 */     this.Tail3.setRotationPoint(0.0F, 4.5F, 34.0F);
/* 119 */     this.Tail3.setTextureSize(256, 256);
/* 120 */     this.Tail3.mirror = true;
/* 121 */     setRotation(this.Tail3, -0.0371786F, 0.0F, 0.0F);
/* 122 */     this.BLegupleft = new ModelRenderer(this, 49, 157);
/* 123 */     this.BLegupleft.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6);
/* 124 */     this.BLegupleft.setRotationPoint(2.0F, 9.0F, 7.0F);
/* 125 */     this.BLegupleft.setTextureSize(256, 256);
/* 126 */     this.BLegupleft.mirror = true;
/* 127 */     setRotation(this.BLegupleft, -0.1487195F, 0.0F, 0.0F);
/* 128 */     this.FLegupleft = new ModelRenderer(this, 49, 141);
/* 129 */     this.FLegupleft.addBox(0.0F, 0.0F, -6.0F, 6, 9, 6);
/* 130 */     this.FLegupleft.setRotationPoint(2.0F, 8.0F, 2.0F);
/* 131 */     this.FLegupleft.setTextureSize(256, 256);
/* 132 */     this.FLegupleft.mirror = true;
/* 133 */     setRotation(this.FLegupleft, 0.0F, 0.0F, 0.0F);
/* 134 */     this.BLegupright = new ModelRenderer(this, 49, 126);
/* 135 */     this.BLegupright.addBox(-6.0F, 0.0F, 0.0F, 6, 8, 6);
/* 136 */     this.BLegupright.setRotationPoint(-2.0F, 9.0F, 7.0F);
/* 137 */     this.BLegupright.setTextureSize(256, 256);
/* 138 */     this.BLegupright.mirror = true;
/* 139 */     setRotation(this.BLegupright, -0.1487144F, 0.0F, 0.0F);
/* 140 */     this.FLegupright = new ModelRenderer(this, 49, 110);
/* 141 */     this.FLegupright.addBox(-6.0F, 0.0F, -6.0F, 6, 9, 6);
/* 142 */     this.FLegupright.setRotationPoint(-2.0F, 8.0F, 2.0F);
/* 143 */     this.FLegupright.setTextureSize(256, 256);
/* 144 */     this.FLegupright.mirror = true;
/* 145 */     setRotation(this.FLegupright, 0.0F, 0.0F, 0.0F);
/* 146 */     this.BLegdownright = new ModelRenderer(this, 115, 157);
/* 147 */     this.BLegdownright.addBox(-5.0F, 7.0F, -1.0F, 5, 8, 5);
/* 148 */     this.BLegdownright.setRotationPoint(-2.0F, 9.0F, 7.0F);
/* 149 */     this.BLegdownright.setTextureSize(256, 256);
/* 150 */     this.BLegdownright.mirror = true;
/* 151 */     setRotation(this.BLegdownright, 0.0F, 0.0F, 0.0F);
/* 152 */     this.FLegdownleft = new ModelRenderer(this, 94, 143);
/* 153 */     this.FLegdownleft.addBox(0.0F, 8.0F, -6.0F, 5, 8, 5);
/* 154 */     this.FLegdownleft.setRotationPoint(2.0F, 8.0F, 2.0F);
/* 155 */     this.FLegdownleft.setTextureSize(256, 256);
/* 156 */     this.FLegdownleft.mirror = true;
/* 157 */     setRotation(this.FLegdownleft, 0.0F, 0.0F, 0.0F);
/* 158 */     this.FLegdownright = new ModelRenderer(this, 94, 157);
/* 159 */     this.FLegdownright.addBox(-5.0F, 8.0F, -6.0F, 5, 8, 5);
/* 160 */     this.FLegdownright.setRotationPoint(-2.0F, 8.0F, 2.0F);
/* 161 */     this.FLegdownright.setTextureSize(256, 256);
/* 162 */     this.FLegdownright.mirror = true;
/* 163 */     setRotation(this.FLegdownright, 0.0F, 0.0F, 0.0F);
/* 164 */     this.BLegdownleft = new ModelRenderer(this, 115, 143);
/* 165 */     this.BLegdownleft.addBox(0.0F, 7.0F, -1.0F, 5, 8, 5);
/* 166 */     this.BLegdownleft.setRotationPoint(2.0F, 9.0F, 7.0F);
/* 167 */     this.BLegdownleft.setTextureSize(256, 256);
/* 168 */     this.BLegdownleft.mirror = true;
/* 169 */     setRotation(this.BLegdownleft, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 176 */     Camarasaurus c = (Camarasaurus)entity;
/* 177 */     float hf = 0.0F;
/* 178 */     float newangle = 0.0F;
/*     */     
/* 180 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 181 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 184 */     if (f1 > 0.1D) {
/* 185 */       newangle = MathHelper.cos(f2 * 0.4F * this.wingspeed) * 3.1415927F * 0.25F * f1;
/*     */     } else {
/* 187 */       newangle = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 191 */     this.FLegupleft.rotateAngleX = newangle;
/* 192 */     this.FLegdownleft.rotateAngleX = newangle;
/* 193 */     this.FLegupright.rotateAngleX = -newangle;
/* 194 */     this.FLegdownright.rotateAngleX = -newangle;
/* 195 */     this.BLegupleft.rotateAngleX = -0.15F - newangle;
/* 196 */     this.BLegdownleft.rotateAngleX = -newangle;
/* 197 */     this.BLegupright.rotateAngleX = -0.15F + newangle;
/* 198 */     this.BLegdownright.rotateAngleX = newangle;
/*     */ 
/*     */     
/* 201 */     hf = c.getCamarasaurusHealth() / c.getMaxHealth();
/* 202 */     newangle = MathHelper.cos(f2 * 0.8F * this.wingspeed * hf) * 3.1415927F * 0.25F * hf;
/* 203 */     if (c.isSitting() == true) {
/* 204 */       newangle = 0.0F;
/*     */     }
/* 206 */     this.Tail0.rotateAngleY = newangle * 0.25F;
/* 207 */     this.Tail0.rotationPointZ += (float)Math.cos(this.Tail0.rotateAngleY) * 5.0F;
/* 208 */     this.Tail0.rotationPointX += (float)Math.sin(this.Tail0.rotateAngleY) * 5.0F;
/* 209 */     this.Tail1.rotateAngleY = newangle * 0.5F;
/* 210 */     this.Tail1.rotationPointZ += (float)Math.cos(this.Tail1.rotateAngleY) * 8.0F;
/* 211 */     this.Tail1.rotationPointX += (float)Math.sin(this.Tail1.rotateAngleY) * 8.0F;
/* 212 */     this.Tail2.rotateAngleY = newangle * 0.75F;
/* 213 */     this.Tail2.rotationPointZ += (float)Math.cos(this.Tail2.rotateAngleY) * 7.0F;
/* 214 */     this.Tail2.rotationPointX += (float)Math.sin(this.Tail2.rotateAngleY) * 7.0F;
/* 215 */     this.Tail3.rotateAngleY = newangle * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 219 */     this.Neck1.rotateAngleY = (float)Math.toRadians(f3) * 0.125F;
/* 220 */     this.Neck2.rotationPointZ = this.Neck1.rotationPointZ;
/* 221 */     this.Neck2.rotationPointX = this.Neck1.rotationPointX;
/* 222 */     this.Neck2.rotateAngleY = (float)Math.toRadians(f3) * 0.25F;
/* 223 */     this.Neck2.rotationPointZ -= (float)Math.cos(this.Neck2.rotateAngleY) * 6.0F;
/* 224 */     this.Neck2.rotationPointX -= (float)Math.sin(this.Neck2.rotateAngleY) * 6.0F;
/* 225 */     this.Neck3.rotateAngleY = (float)Math.toRadians(f3) * 0.38F;
/* 226 */     this.Neck3.rotationPointZ -= (float)Math.cos(this.Neck3.rotateAngleY) * 7.0F;
/* 227 */     this.Neck3.rotationPointX -= (float)Math.sin(this.Neck3.rotateAngleY) * 7.0F;
/* 228 */     this.Head1.rotateAngleY = (float)Math.toRadians(f3);
/* 229 */     this.Head1.rotationPointZ -= (float)Math.cos(this.Head1.rotateAngleY) * 5.0F;
/* 230 */     this.Head1.rotationPointX -= (float)Math.sin(this.Head1.rotateAngleY) * 5.0F;
/* 231 */     this.Head2.rotateAngleY = (float)Math.toRadians(f3);
/*     */     
/* 233 */     if (this.isChild) {
/* 234 */       GL11.glPushMatrix();
/*     */       
/* 236 */       GL11.glTranslatef(0.0F, 0.9F, 0.0F);
/*     */       
/* 238 */       GL11.glScalef(0.4F, 0.4F, 0.4F);
/*     */       
/* 240 */       this.Body1.render(f5);
/* 241 */       this.Body2.render(f5);
/* 242 */       this.Body3.render(f5);
/* 243 */       this.Body4.render(f5);
/* 244 */       this.Tail0.render(f5);
/* 245 */       this.Neck1.render(f5);
/* 246 */       this.Neck2.render(f5);
/* 247 */       this.Neck3.render(f5);
/* 248 */       this.Head1.render(f5);
/* 249 */       this.Head2.render(f5);
/* 250 */       this.Tail1.render(f5);
/* 251 */       this.Tail2.render(f5);
/* 252 */       this.Tail3.render(f5);
/*     */       
/* 254 */       this.FLegupleft.render(f5);
/* 255 */       this.FLegdownleft.render(f5);
/* 256 */       this.FLegupright.render(f5);
/* 257 */       this.FLegdownright.render(f5);
/* 258 */       this.BLegupleft.render(f5);
/* 259 */       this.BLegdownright.render(f5);
/* 260 */       this.BLegupright.render(f5);
/* 261 */       this.BLegdownleft.render(f5);
/*     */ 
/*     */ 
/*     */       
/* 265 */       GL11.glPopMatrix();
/*     */     } else {
/* 267 */       GL11.glPushMatrix();
/*     */       
/* 269 */       GL11.glTranslatef(0.0F, 0.45000005F, 0.0F);
/*     */       
/* 271 */       GL11.glScalef(0.7F, 0.7F, 0.7F);
/*     */       
/* 273 */       this.Body1.render(f5);
/* 274 */       this.Body2.render(f5);
/* 275 */       this.Body3.render(f5);
/* 276 */       this.Body4.render(f5);
/* 277 */       this.Tail0.render(f5);
/* 278 */       this.Neck1.render(f5);
/* 279 */       this.Neck2.render(f5);
/* 280 */       this.Neck3.render(f5);
/* 281 */       this.Head1.render(f5);
/* 282 */       this.Head2.render(f5);
/* 283 */       this.Tail1.render(f5);
/* 284 */       this.Tail2.render(f5);
/* 285 */       this.Tail3.render(f5);
/*     */       
/* 287 */       this.FLegupleft.render(f5);
/* 288 */       this.FLegdownleft.render(f5);
/* 289 */       this.FLegupright.render(f5);
/* 290 */       this.FLegdownright.render(f5);
/* 291 */       this.BLegupleft.render(f5);
/* 292 */       this.BLegdownright.render(f5);
/* 293 */       this.BLegupright.render(f5);
/* 294 */       this.BLegdownleft.render(f5);
/*     */       
/* 296 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 302 */     model.rotateAngleX = x;
/* 303 */     model.rotateAngleY = y;
/* 304 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 308 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.8-deobf.jar!\danger\orespawn\entity\model\ModelCamarasaurus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */