/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelRockBase
/*     */   extends ModelBase
/*     */ {
/*  14 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer RockShape1;
/*     */   
/*     */   ModelRenderer RockShape2;
/*     */   
/*     */   ModelRenderer RockShape3;
/*     */   
/*     */   ModelRenderer RockSmallShape2;
/*     */   
/*     */   ModelRenderer RockSmallShape1;
/*     */   
/*     */   ModelRenderer RockTNTShape1;
/*     */   
/*     */   ModelRenderer RockTNTShape2;
/*     */   ModelRenderer RockTNTShape3;
/*     */   ModelRenderer RockTNTShape4;
/*     */   ModelRenderer RockSpikeyShape1;
/*     */   ModelRenderer RockSpikeyShape2;
/*     */   ModelRenderer RockSpikeyShape3;
/*     */   ModelRenderer CrystalShape1;
/*     */   ModelRenderer CrystalShape2;
/*     */   ModelRenderer CrystalShape3a;
/*     */   ModelRenderer CrystalShape3b;
/*     */   ModelRenderer CrystalShape3c;
/*     */   ModelRenderer CrystalShape3d;
/*     */   ModelRenderer CrystalShape4a;
/*     */   ModelRenderer CrystalShape4b;
/*     */   ModelRenderer CrystalShape4c;
/*     */   ModelRenderer CrystalShape4d;
/*     */   
/*     */   public ModelRockBase(float f1) {
/*  46 */     this.wingspeed = f1;
/*     */     
/*  48 */     this.textureWidth = 64;
/*  49 */     this.textureHeight = 64;
/*     */     
/*  51 */     this.RockShape1 = new ModelRenderer(this, 0, 0);
/*  52 */     this.RockShape1.addBox(-3.0F, 0.0F, -1.0F, 6, 1, 2);
/*  53 */     this.RockShape1.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  54 */     this.RockShape1.setTextureSize(64, 32);
/*  55 */     this.RockShape1.mirror = true;
/*  56 */     setRotation(this.RockShape1, 0.0F, 0.0F, 0.0F);
/*  57 */     this.RockShape2 = new ModelRenderer(this, 0, 4);
/*  58 */     this.RockShape2.addBox(-3.0F, 0.0F, 1.0F, 3, 1, 1);
/*  59 */     this.RockShape2.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  60 */     this.RockShape2.setTextureSize(64, 64);
/*  61 */     this.RockShape2.mirror = true;
/*  62 */     setRotation(this.RockShape2, 0.0F, 0.0F, 0.0F);
/*  63 */     this.RockShape3 = new ModelRenderer(this, 0, 7);
/*  64 */     this.RockShape3.addBox(0.0F, 0.0F, -2.0F, 2, 1, 1);
/*  65 */     this.RockShape3.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  66 */     this.RockShape3.setTextureSize(64, 64);
/*  67 */     this.RockShape3.mirror = true;
/*  68 */     setRotation(this.RockShape3, 0.0F, 0.0F, 0.0F);
/*     */     
/*  70 */     this.RockSmallShape2 = new ModelRenderer(this, 0, 4);
/*  71 */     this.RockSmallShape2.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1);
/*  72 */     this.RockSmallShape2.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  73 */     this.RockSmallShape2.setTextureSize(64, 64);
/*  74 */     this.RockSmallShape2.mirror = true;
/*  75 */     setRotation(this.RockSmallShape2, 0.0F, 0.0F, 0.0F);
/*  76 */     this.RockSmallShape1 = new ModelRenderer(this, 0, 7);
/*  77 */     this.RockSmallShape1.addBox(0.0F, 0.0F, -1.0F, 2, 1, 1);
/*  78 */     this.RockSmallShape1.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  79 */     this.RockSmallShape1.setTextureSize(64, 64);
/*  80 */     this.RockSmallShape1.mirror = true;
/*  81 */     setRotation(this.RockSmallShape1, 0.0F, 0.0F, 0.0F);
/*     */     
/*  83 */     this.RockTNTShape1 = new ModelRenderer(this, 0, 0);
/*  84 */     this.RockTNTShape1.addBox(-3.0F, 0.0F, -1.0F, 6, 1, 2);
/*  85 */     this.RockTNTShape1.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  86 */     this.RockTNTShape1.setTextureSize(64, 64);
/*  87 */     this.RockTNTShape1.mirror = true;
/*  88 */     setRotation(this.RockTNTShape1, 0.0F, 0.0F, 0.0F);
/*  89 */     this.RockTNTShape2 = new ModelRenderer(this, 0, 4);
/*  90 */     this.RockTNTShape2.addBox(-3.0F, 0.0F, 1.0F, 3, 1, 1);
/*  91 */     this.RockTNTShape2.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  92 */     this.RockTNTShape2.setTextureSize(64, 64);
/*  93 */     this.RockTNTShape2.mirror = true;
/*  94 */     setRotation(this.RockTNTShape2, 0.0F, 0.0F, 0.0F);
/*  95 */     this.RockTNTShape3 = new ModelRenderer(this, 0, 7);
/*  96 */     this.RockTNTShape3.addBox(0.0F, 0.0F, -2.0F, 2, 1, 1);
/*  97 */     this.RockTNTShape3.setRotationPoint(0.0F, 23.0F, 0.0F);
/*  98 */     this.RockTNTShape3.setTextureSize(64, 64);
/*  99 */     this.RockTNTShape3.mirror = true;
/* 100 */     setRotation(this.RockTNTShape3, 0.0F, 0.0F, 0.0F);
/* 101 */     this.RockTNTShape4 = new ModelRenderer(this, 0, 10);
/* 102 */     this.RockTNTShape4.addBox(-4.0F, 0.0F, -2.0F, 3, 1, 3);
/* 103 */     this.RockTNTShape4.setRotationPoint(0.0F, 22.0F, 0.0F);
/* 104 */     this.RockTNTShape4.setTextureSize(64, 64);
/* 105 */     this.RockTNTShape4.mirror = true;
/* 106 */     setRotation(this.RockTNTShape4, 0.0F, 0.0F, 0.0F);
/*     */     
/* 108 */     this.RockSpikeyShape1 = new ModelRenderer(this, 0, 0);
/* 109 */     this.RockSpikeyShape1.addBox(-3.0F, 0.0F, -1.0F, 6, 1, 2);
/* 110 */     this.RockSpikeyShape1.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 111 */     this.RockSpikeyShape1.setTextureSize(64, 64);
/* 112 */     this.RockSpikeyShape1.mirror = true;
/* 113 */     setRotation(this.RockSpikeyShape1, 0.0F, 0.0F, 0.0F);
/* 114 */     this.RockSpikeyShape2 = new ModelRenderer(this, 0, 4);
/* 115 */     this.RockSpikeyShape2.addBox(-4.0F, 0.0F, -1.0F, 3, 1, 1);
/* 116 */     this.RockSpikeyShape2.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 117 */     this.RockSpikeyShape2.setTextureSize(64, 64);
/* 118 */     this.RockSpikeyShape2.mirror = true;
/* 119 */     setRotation(this.RockSpikeyShape2, 0.0F, 1.570796F, 0.0F);
/* 120 */     this.RockSpikeyShape3 = new ModelRenderer(this, 0, 7);
/* 121 */     this.RockSpikeyShape3.addBox(1.0F, 0.0F, 1.0F, 2, 1, 1);
/* 122 */     this.RockSpikeyShape3.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 123 */     this.RockSpikeyShape3.setTextureSize(64, 64);
/* 124 */     this.RockSpikeyShape3.mirror = true;
/* 125 */     setRotation(this.RockSpikeyShape3, 0.0F, 1.570796F, 0.0F);
/*     */     
/* 127 */     this.CrystalShape1 = new ModelRenderer(this, 0, 0);
/* 128 */     this.CrystalShape1.addBox(-1.0F, -4.0F, -1.0F, 2, 5, 2);
/* 129 */     this.CrystalShape1.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 130 */     this.CrystalShape1.setTextureSize(64, 64);
/* 131 */     this.CrystalShape1.mirror = true;
/* 132 */     setRotation(this.CrystalShape1, 0.0F, 0.0F, 0.0F);
/* 133 */     this.CrystalShape2 = new ModelRenderer(this, 10, 0);
/* 134 */     this.CrystalShape2.addBox(-0.5F, -7.0F, -0.5F, 1, 3, 1);
/* 135 */     this.CrystalShape2.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 136 */     this.CrystalShape2.setTextureSize(64, 64);
/* 137 */     this.CrystalShape2.mirror = true;
/* 138 */     setRotation(this.CrystalShape2, 0.0F, 0.0F, 0.0F);
/* 139 */     this.CrystalShape3a = new ModelRenderer(this, 0, 8);
/* 140 */     this.CrystalShape3a.addBox(-1.0F, -5.0F, -1.0F, 1, 5, 1);
/* 141 */     this.CrystalShape3a.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 142 */     this.CrystalShape3a.setTextureSize(64, 64);
/* 143 */     this.CrystalShape3a.mirror = true;
/* 144 */     setRotation(this.CrystalShape3a, 0.5410521F, 0.0F, 0.0F);
/* 145 */     this.CrystalShape3b = new ModelRenderer(this, 0, 8);
/* 146 */     this.CrystalShape3b.addBox(0.0F, -5.0F, 0.0F, 1, 5, 1);
/* 147 */     this.CrystalShape3b.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 148 */     this.CrystalShape3b.setTextureSize(64, 64);
/* 149 */     this.CrystalShape3b.mirror = true;
/* 150 */     setRotation(this.CrystalShape3b, -0.5410521F, 0.0F, 0.0F);
/* 151 */     this.CrystalShape3c = new ModelRenderer(this, 0, 8);
/* 152 */     this.CrystalShape3c.addBox(0.0F, -5.0F, -1.0F, 1, 5, 1);
/* 153 */     this.CrystalShape3c.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 154 */     this.CrystalShape3c.setTextureSize(64, 64);
/* 155 */     this.CrystalShape3c.mirror = true;
/* 156 */     setRotation(this.CrystalShape3c, 0.0F, 0.0F, 0.5410521F);
/* 157 */     this.CrystalShape3d = new ModelRenderer(this, 0, 8);
/* 158 */     this.CrystalShape3d.addBox(-1.0F, -5.0F, 0.0F, 1, 5, 1);
/* 159 */     this.CrystalShape3d.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 160 */     this.CrystalShape3d.setTextureSize(64, 64);
/* 161 */     this.CrystalShape3d.mirror = true;
/* 162 */     setRotation(this.CrystalShape3d, 0.0F, 0.0F, -0.5410521F);
/* 163 */     this.CrystalShape4a = new ModelRenderer(this, 0, 16);
/* 164 */     this.CrystalShape4a.addBox(0.0F, -3.0F, -1.0F, 1, 3, 1);
/* 165 */     this.CrystalShape4a.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 166 */     this.CrystalShape4a.setTextureSize(64, 64);
/* 167 */     this.CrystalShape4a.mirror = true;
/* 168 */     setRotation(this.CrystalShape4a, 1.308997F, 0.0F, 0.0F);
/* 169 */     this.CrystalShape4b = new ModelRenderer(this, 0, 16);
/* 170 */     this.CrystalShape4b.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1);
/* 171 */     this.CrystalShape4b.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 172 */     this.CrystalShape4b.setTextureSize(64, 64);
/* 173 */     this.CrystalShape4b.mirror = true;
/* 174 */     setRotation(this.CrystalShape4b, -1.308997F, 0.0F, 0.0F);
/* 175 */     this.CrystalShape4c = new ModelRenderer(this, 0, 16);
/* 176 */     this.CrystalShape4c.addBox(0.0F, -3.0F, 0.0F, 1, 3, 1);
/* 177 */     this.CrystalShape4c.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 178 */     this.CrystalShape4c.setTextureSize(64, 64);
/* 179 */     this.CrystalShape4c.mirror = true;
/* 180 */     setRotation(this.CrystalShape4c, 0.0F, 0.0F, 1.308997F);
/* 181 */     this.CrystalShape4d = new ModelRenderer(this, 0, 16);
/* 182 */     this.CrystalShape4d.addBox(-1.0F, -3.0F, -1.0F, 1, 3, 1);
/* 183 */     this.CrystalShape4d.setRotationPoint(0.0F, 23.0F, 0.0F);
/* 184 */     this.CrystalShape4d.setTextureSize(64, 64);
/* 185 */     this.CrystalShape4d.mirror = true;
/* 186 */     setRotation(this.CrystalShape4d, 0.0F, 0.0F, -1.308997F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 193 */     RockBase r = (RockBase)entity;
/* 194 */     int rt = 0;
/* 195 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 196 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 198 */     rt = r.getRockType();
/* 199 */     if (rt < 1 || rt > 12)
/*     */       return; 
/* 201 */     if (rt == 1) {
/* 202 */       this.RockSmallShape1.render(f5);
/* 203 */       this.RockSmallShape2.render(f5);
/* 204 */     } else if (rt == 7) {
/* 205 */       this.RockSpikeyShape1.render(f5);
/* 206 */       this.RockSpikeyShape2.render(f5);
/* 207 */       this.RockSpikeyShape3.render(f5);
/* 208 */     } else if (rt == 8) {
/* 209 */       this.RockTNTShape1.render(f5);
/* 210 */       this.RockTNTShape2.render(f5);
/* 211 */       this.RockTNTShape3.render(f5);
/* 212 */       this.RockTNTShape4.render(f5);
/* 213 */     } else if (rt >= 9 && rt <= 12) {
/* 214 */       GL11.glPushMatrix();
/* 215 */       GL11.glEnable(2977);
/* 216 */       GL11.glEnable(3042);
/* 217 */       GL11.glBlendFunc(770, 771);
/* 218 */       OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
/* 219 */       GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.55F);
/* 220 */       this.CrystalShape1.render(f5);
/* 221 */       this.CrystalShape2.render(f5);
/* 222 */       this.CrystalShape3a.render(f5);
/* 223 */       this.CrystalShape3b.render(f5);
/* 224 */       this.CrystalShape3c.render(f5);
/* 225 */       this.CrystalShape3d.render(f5);
/* 226 */       this.CrystalShape4a.render(f5);
/* 227 */       this.CrystalShape4b.render(f5);
/* 228 */       this.CrystalShape4c.render(f5);
/* 229 */       this.CrystalShape4d.render(f5);
/* 230 */       GL11.glDisable(3042);
/* 231 */       GL11.glPopMatrix();
/*     */     } else {
/* 233 */       this.RockShape1.render(f5);
/* 234 */       this.RockShape2.render(f5);
/* 235 */       this.RockShape3.render(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 242 */     model.rotateAngleX = x;
/* 243 */     model.rotateAngleY = y;
/* 244 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 249 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelRockBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */