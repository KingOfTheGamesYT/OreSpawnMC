/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelTerribleTerror
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Horn1;
/*     */   
/*     */   ModelRenderer Horn2;
/*     */   
/*     */   ModelRenderer Snout;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer Jaw;
/*     */   ModelRenderer Neck;
/*     */   ModelRenderer Body;
/*     */   ModelRenderer Wing1;
/*     */   ModelRenderer Wing2;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail3;
/*     */   ModelRenderer Tail4;
/*     */   ModelRenderer FL11;
/*     */   ModelRenderer FL12;
/*     */   ModelRenderer FL21;
/*     */   ModelRenderer FL22;
/*     */   ModelRenderer BL21;
/*     */   ModelRenderer BL22;
/*     */   ModelRenderer BL11;
/*     */   ModelRenderer BL12;
/*     */   
/*     */   public ModelTerribleTerror() {
/*  37 */     this.wingspeed = 1.0F;
/*  38 */     this.textureWidth = 119;
/*  39 */     this.textureHeight = 72;
/*     */     
/*  41 */     this.Horn1 = new ModelRenderer(this, 90, 0);
/*  42 */     this.Horn1.addBox(1.0F, -4.0F, 0.0F, 0, 2, 2);
/*  43 */     this.Horn1.setRotationPoint(0.0F, 17.0F, -6.0F);
/*  44 */     this.Horn1.setTextureSize(119, 72);
/*  45 */     this.Horn1.mirror = true;
/*  46 */     setRotation(this.Horn1, 0.0F, 0.0F, 0.0F);
/*  47 */     this.Horn2 = new ModelRenderer(this, 102, 0);
/*  48 */     this.Horn2.addBox(-1.0F, -4.0F, 0.0F, 0, 2, 2);
/*  49 */     this.Horn2.setRotationPoint(0.0F, 17.0F, -6.0F);
/*  50 */     this.Horn2.setTextureSize(119, 72);
/*  51 */     this.Horn2.mirror = true;
/*  52 */     setRotation(this.Horn2, 0.0F, 0.0F, 0.0F);
/*  53 */     this.Snout = new ModelRenderer(this, 64, 0);
/*  54 */     this.Snout.addBox(-2.0F, -1.0F, -4.0F, 4, 1, 4);
/*  55 */     this.Snout.setRotationPoint(0.0F, 17.0F, -6.0F);
/*  56 */     this.Snout.setTextureSize(119, 72);
/*  57 */     this.Snout.mirror = true;
/*  58 */     setRotation(this.Snout, 0.0F, 0.0F, 0.0F);
/*  59 */     this.Head = new ModelRenderer(this, 41, 0);
/*  60 */     this.Head.addBox(-2.0F, -2.0F, -2.0F, 4, 1, 2);
/*  61 */     this.Head.setRotationPoint(0.0F, 17.0F, -6.0F);
/*  62 */     this.Head.setTextureSize(119, 72);
/*  63 */     this.Head.mirror = true;
/*  64 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*  65 */     this.Jaw = new ModelRenderer(this, 42, 5);
/*  66 */     this.Jaw.addBox(-2.0F, 0.0F, -4.0F, 4, 1, 4);
/*  67 */     this.Jaw.setRotationPoint(0.0F, 17.0F, -6.0F);
/*  68 */     this.Jaw.setTextureSize(119, 72);
/*  69 */     this.Jaw.mirror = true;
/*  70 */     setRotation(this.Jaw, 0.0F, 0.0F, 0.0F);
/*  71 */     this.Neck = new ModelRenderer(this, 30, 0);
/*  72 */     this.Neck.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
/*  73 */     this.Neck.setRotationPoint(-1.0F, 18.0F, -2.0F);
/*  74 */     this.Neck.setTextureSize(119, 72);
/*  75 */     this.Neck.mirror = true;
/*  76 */     setRotation(this.Neck, -2.082002F, 0.0F, 0.0F);
/*  77 */     this.Body = new ModelRenderer(this, 38, 16);
/*  78 */     this.Body.addBox(0.0F, 0.0F, 0.0F, 2, 3, 10);
/*  79 */     this.Body.setRotationPoint(-1.0F, 17.0F, -4.0F);
/*  80 */     this.Body.setTextureSize(119, 72);
/*  81 */     this.Body.mirror = true;
/*  82 */     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
/*  83 */     this.Wing1 = new ModelRenderer(this, 36, 37);
/*  84 */     this.Wing1.addBox(0.0F, 0.0F, 0.0F, 0, 11, 15);
/*  85 */     this.Wing1.setRotationPoint(0.0F, 18.0F, -1.0F);
/*  86 */     this.Wing1.setTextureSize(119, 72);
/*  87 */     this.Wing1.mirror = true;
/*  88 */     setRotation(this.Wing1, -0.3490659F, 0.0F, -2.356194F);
/*  89 */     this.Wing2 = new ModelRenderer(this, 0, 37);
/*  90 */     this.Wing2.addBox(0.0F, 0.0F, 0.0F, 0, 11, 15);
/*  91 */     this.Wing2.setRotationPoint(0.0F, 18.0F, -1.0F);
/*  92 */     this.Wing2.setTextureSize(119, 72);
/*  93 */     this.Wing2.mirror = true;
/*  94 */     setRotation(this.Wing2, -0.3490659F, 0.0F, 2.356194F);
/*  95 */     this.Tail1 = new ModelRenderer(this, 14, 0);
/*  96 */     this.Tail1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
/*  97 */     this.Tail1.setRotationPoint(-0.5F, 17.0F, 6.0F);
/*  98 */     this.Tail1.setTextureSize(119, 72);
/*  99 */     this.Tail1.mirror = true;
/* 100 */     setRotation(this.Tail1, -0.5235988F, 0.0F, 0.0F);
/* 101 */     this.Tail2 = new ModelRenderer(this, 14, 8);
/* 102 */     this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
/* 103 */     this.Tail2.setRotationPoint(-0.5F, 20.0F, 11.0F);
/* 104 */     this.Tail2.setTextureSize(119, 72);
/* 105 */     this.Tail2.mirror = true;
/* 106 */     setRotation(this.Tail2, 0.0F, 0.0F, 0.0F);
/* 107 */     this.Tail3 = new ModelRenderer(this, 17, 16);
/* 108 */     this.Tail3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4);
/* 109 */     this.Tail3.setRotationPoint(-0.5F, 20.0F, 17.0F);
/* 110 */     this.Tail3.setTextureSize(119, 72);
/* 111 */     this.Tail3.mirror = true;
/* 112 */     setRotation(this.Tail3, 0.0F, -0.6320364F, 0.0F);
/* 113 */     this.Tail4 = new ModelRenderer(this, 16, 23);
/* 114 */     this.Tail4.addBox(-1.0F, 0.5F, 4.0F, 3, 0, 2);
/* 115 */     this.Tail4.setRotationPoint(-0.5F, 20.0F, 17.0F);
/* 116 */     this.Tail4.setTextureSize(119, 72);
/* 117 */     this.Tail4.mirror = true;
/* 118 */     setRotation(this.Tail4, 0.0F, -0.6320364F, 0.0F);
/* 119 */     this.FL11 = new ModelRenderer(this, 0, 9);
/* 120 */     this.FL11.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/* 121 */     this.FL11.setRotationPoint(-2.0F, 19.0F, -4.0F);
/* 122 */     this.FL11.setTextureSize(119, 72);
/* 123 */     this.FL11.mirror = true;
/* 124 */     setRotation(this.FL11, 0.3490659F, 0.0F, 0.1745329F);
/* 125 */     this.FL12 = new ModelRenderer(this, 0, 13);
/* 126 */     this.FL12.addBox(-0.5F, 1.0F, 1.0F, 1, 2, 1);
/* 127 */     this.FL12.setRotationPoint(-2.0F, 19.0F, -4.0F);
/* 128 */     this.FL12.setTextureSize(119, 72);
/* 129 */     this.FL12.mirror = true;
/* 130 */     setRotation(this.FL12, -0.2617994F, 0.0F, 0.0F);
/* 131 */     this.FL21 = new ModelRenderer(this, 5, 9);
/* 132 */     this.FL21.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/* 133 */     this.FL21.setRotationPoint(1.0F, 19.0F, -4.0F);
/* 134 */     this.FL21.setTextureSize(119, 72);
/* 135 */     this.FL21.mirror = true;
/* 136 */     setRotation(this.FL21, 0.3490659F, 0.0F, -0.1745329F);
/* 137 */     this.FL22 = new ModelRenderer(this, 5, 13);
/* 138 */     this.FL22.addBox(0.5F, 1.0F, 1.0F, 1, 2, 1);
/* 139 */     this.FL22.setRotationPoint(1.0F, 19.0F, -4.0F);
/* 140 */     this.FL22.setTextureSize(119, 72);
/* 141 */     this.FL22.mirror = true;
/* 142 */     setRotation(this.FL22, -0.2617994F, 0.0F, 0.0F);
/* 143 */     this.BL21 = new ModelRenderer(this, 0, 18);
/* 144 */     this.BL21.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/* 145 */     this.BL21.setRotationPoint(1.0F, 18.0F, 4.0F);
/* 146 */     this.BL21.setTextureSize(119, 72);
/* 147 */     this.BL21.mirror = true;
/* 148 */     setRotation(this.BL21, -0.3490659F, 0.0F, -0.1745329F);
/* 149 */     this.BL22 = new ModelRenderer(this, 0, 22);
/* 150 */     this.BL22.addBox(0.5F, 2.0F, -1.0F, 1, 2, 1);
/* 151 */     this.BL22.setRotationPoint(1.0F, 18.0F, 4.0F);
/* 152 */     this.BL22.setTextureSize(119, 72);
/* 153 */     this.BL22.mirror = true;
/* 154 */     setRotation(this.BL22, 0.1745329F, 0.0F, 0.0F);
/* 155 */     this.BL11 = new ModelRenderer(this, 5, 18);
/* 156 */     this.BL11.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/* 157 */     this.BL11.setRotationPoint(-2.0F, 18.0F, 4.0F);
/* 158 */     this.BL11.setTextureSize(119, 72);
/* 159 */     this.BL11.mirror = true;
/* 160 */     setRotation(this.BL11, -0.3490659F, 0.0F, 0.1745329F);
/* 161 */     this.BL12 = new ModelRenderer(this, 5, 22);
/* 162 */     this.BL12.addBox(-0.5F, 2.0F, -1.0F, 1, 2, 1);
/* 163 */     this.BL12.setRotationPoint(-2.0F, 18.0F, 4.0F);
/* 164 */     this.BL12.setTextureSize(119, 72);
/* 165 */     this.BL12.mirror = true;
/* 166 */     setRotation(this.BL12, 0.1745329F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 172 */     float newangle = 0.0F;
/*     */     
/* 174 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 175 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 178 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 179 */     this.Wing1.rotateAngleZ = -2.0F + newangle;
/* 180 */     this.Wing2.rotateAngleZ = 2.0F - newangle;
/*     */ 
/*     */     
/* 183 */     newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.1F;
/* 184 */     this.Jaw.rotateAngleX = Math.abs(newangle);
/*     */     
/* 186 */     newangle = MathHelper.cos(f2 * 1.25F) * 3.1415927F * 0.35F;
/* 187 */     this.FL21.rotateAngleX = 0.349F + newangle;
/* 188 */     this.FL22.rotateAngleX = -0.296F + newangle;
/* 189 */     this.BL21.rotateAngleX = -0.349F - newangle;
/* 190 */     this.BL22.rotateAngleX = 0.174F - newangle;
/* 191 */     this.FL11.rotateAngleX = 0.349F - newangle;
/* 192 */     this.FL12.rotateAngleX = -0.296F - newangle;
/* 193 */     this.BL11.rotateAngleX = -0.349F + newangle;
/* 194 */     this.BL12.rotateAngleX = 0.174F + newangle;
/*     */     
/* 196 */     newangle = MathHelper.cos(f2 * 0.71F * this.wingspeed) * 3.1415927F * 0.1F;
/* 197 */     this.Tail1.rotateAngleX = newangle;
/* 198 */     newangle = MathHelper.cos(f2 * 0.77F * this.wingspeed) * 3.1415927F * 0.1F;
/* 199 */     this.Tail1.rotateAngleY = newangle;
/*     */     
/* 201 */     float dist = 6.0F;
/* 202 */     dist = (float)(dist * Math.cos(this.Tail1.rotateAngleX));
/* 203 */     this.Tail2.rotationPointY = (float)(this.Tail1.rotationPointY - Math.sin(this.Tail1.rotateAngleX) * dist);
/* 204 */     this.Tail2.rotationPointX = (float)(this.Tail1.rotationPointX + Math.sin(this.Tail1.rotateAngleY) * dist);
/*     */     
/* 206 */     newangle = MathHelper.cos(f2 * 0.81F * this.wingspeed) * 3.1415927F * 0.15F;
/* 207 */     this.Tail2.rotateAngleX = newangle;
/* 208 */     newangle = MathHelper.cos(f2 * 0.87F * this.wingspeed) * 3.1415927F * 0.15F;
/* 209 */     this.Tail2.rotateAngleY = newangle;
/*     */     
/* 211 */     dist = 6.0F;
/* 212 */     dist = (float)(dist * Math.cos(this.Tail2.rotateAngleX));
/* 213 */     this.Tail4.rotationPointY = (float)(this.Tail2.rotationPointY - Math.sin(this.Tail2.rotateAngleX) * dist);
/* 214 */     this.Tail4.rotationPointX = (float)(this.Tail2.rotationPointX + Math.sin(this.Tail2.rotateAngleY) * dist);
/*     */     
/* 216 */     newangle = MathHelper.cos(f2 * 0.91F * this.wingspeed) * 3.1415927F * 0.2F;
/* 217 */     this.Tail4.rotateAngleX = newangle;
/* 218 */     newangle = MathHelper.cos(f2 * 0.97F * this.wingspeed) * 3.1415927F * 0.2F;
/* 219 */     this.Tail4.rotateAngleY = newangle;
/*     */ 
/*     */     
/* 222 */     this.Horn1.render(f5);
/* 223 */     this.Horn2.render(f5);
/* 224 */     this.Snout.render(f5);
/* 225 */     this.Head.render(f5);
/* 226 */     this.Jaw.render(f5);
/* 227 */     this.Neck.render(f5);
/* 228 */     this.Body.render(f5);
/* 229 */     this.Wing1.render(f5);
/* 230 */     this.Wing2.render(f5);
/* 231 */     this.Tail1.render(f5);
/* 232 */     this.Tail2.render(f5);
/* 233 */     this.Tail3.render(f5);
/* 234 */     this.Tail4.render(f5);
/* 235 */     this.FL11.render(f5);
/* 236 */     this.FL12.render(f5);
/* 237 */     this.FL21.render(f5);
/* 238 */     this.FL22.render(f5);
/* 239 */     this.BL21.render(f5);
/* 240 */     this.BL22.render(f5);
/* 241 */     this.BL11.render(f5);
/* 242 */     this.BL12.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 249 */     model.rotateAngleX = x;
/* 250 */     model.rotateAngleY = y;
/* 251 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 256 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelTerribleTerror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */