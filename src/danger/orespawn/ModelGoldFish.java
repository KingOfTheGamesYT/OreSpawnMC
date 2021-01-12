/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGoldFish
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Body;
/*     */   
/*     */   ModelRenderer Head;
/*     */   ModelRenderer Dorsalfin;
/*     */   ModelRenderer Mouth;
/*     */   ModelRenderer Jaw;
/*     */   ModelRenderer Pectoralfin1;
/*     */   ModelRenderer Pectoralfin2;
/*     */   ModelRenderer Pectoralfin3;
/*     */   ModelRenderer Pectoralfin4;
/*     */   ModelRenderer Bottomfin;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Caudalfin1;
/*     */   ModelRenderer Caudalfin2;
/*     */   ModelRenderer Bottomfin1;
/*     */   ModelRenderer Bottomfin2;
/*     */   
/*     */   public ModelGoldFish(float f1) {
/*  31 */     this.wingspeed = f1;
/*     */     
/*  33 */     this.textureWidth = 64;
/*  34 */     this.textureHeight = 64;
/*     */     
/*  36 */     this.Body = new ModelRenderer(this, 0, 15);
/*  37 */     this.Body.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 10);
/*  38 */     this.Body.setRotationPoint(0.0F, 14.0F, -5.0F);
/*  39 */     this.Body.setTextureSize(64, 64);
/*  40 */     this.Body.mirror = true;
/*  41 */     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
/*  42 */     this.Head = new ModelRenderer(this, 0, 30);
/*  43 */     this.Head.addBox(-1.5F, -2.0F, -3.0F, 3, 4, 3);
/*  44 */     this.Head.setRotationPoint(0.0F, 14.0F, -5.0F);
/*  45 */     this.Head.setTextureSize(64, 64);
/*  46 */     this.Head.mirror = true;
/*  47 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*  48 */     this.Dorsalfin = new ModelRenderer(this, 29, 0);
/*  49 */     this.Dorsalfin.addBox(0.0F, -6.0F, 0.0F, 0, 4, 10);
/*  50 */     this.Dorsalfin.setRotationPoint(0.0F, 14.0F, -5.0F);
/*  51 */     this.Dorsalfin.setTextureSize(64, 64);
/*  52 */     this.Dorsalfin.mirror = true;
/*  53 */     setRotation(this.Dorsalfin, 0.0F, 0.0F, 0.0F);
/*  54 */     this.Mouth = new ModelRenderer(this, 0, 38);
/*  55 */     this.Mouth.addBox(-1.5F, 0.6F, -3.5F, 3, 3, 3);
/*  56 */     this.Mouth.setRotationPoint(0.0F, 14.0F, -5.0F);
/*  57 */     this.Mouth.setTextureSize(64, 64);
/*  58 */     this.Mouth.mirror = true;
/*  59 */     setRotation(this.Mouth, -0.7853982F, 0.0F, 0.0F);
/*  60 */     this.Jaw = new ModelRenderer(this, 13, 30);
/*  61 */     this.Jaw.addBox(-1.0F, 0.0F, -3.0F, 3, 1, 3);
/*  62 */     this.Jaw.setRotationPoint(-0.5F, 15.6F, -7.4F);
/*  63 */     this.Jaw.setTextureSize(64, 64);
/*  64 */     this.Jaw.mirror = true;
/*  65 */     setRotation(this.Jaw, -0.2284419F, 0.0F, 0.0F);
/*  66 */     this.Pectoralfin1 = new ModelRenderer(this, 0, 0);
/*  67 */     this.Pectoralfin1.addBox(0.0F, -1.5F, 0.0F, 0, 3, 5);
/*  68 */     this.Pectoralfin1.setRotationPoint(-2.0F, 14.0F, -3.0F);
/*  69 */     this.Pectoralfin1.setTextureSize(64, 64);
/*  70 */     this.Pectoralfin1.mirror = true;
/*  71 */     setRotation(this.Pectoralfin1, -0.2974289F, -0.3346075F, 0.0F);
/*  72 */     this.Pectoralfin2 = new ModelRenderer(this, 0, 0);
/*  73 */     this.Pectoralfin2.addBox(0.0F, -1.5F, 0.0F, 0, 3, 5);
/*  74 */     this.Pectoralfin2.setRotationPoint(2.0F, 14.0F, -3.0F);
/*  75 */     this.Pectoralfin2.setTextureSize(64, 64);
/*  76 */     this.Pectoralfin2.mirror = true;
/*  77 */     setRotation(this.Pectoralfin2, -0.2974216F, 0.3346145F, 0.0F);
/*  78 */     this.Pectoralfin3 = new ModelRenderer(this, 0, 0);
/*  79 */     this.Pectoralfin3.addBox(0.0F, -1.5F, 0.0F, 0, 3, 5);
/*  80 */     this.Pectoralfin3.setRotationPoint(-2.0F, 14.0F, 1.0F);
/*  81 */     this.Pectoralfin3.setTextureSize(64, 64);
/*  82 */     this.Pectoralfin3.mirror = true;
/*  83 */     setRotation(this.Pectoralfin3, -0.2974289F, -0.3346075F, 0.0F);
/*  84 */     this.Pectoralfin4 = new ModelRenderer(this, 0, 0);
/*  85 */     this.Pectoralfin4.addBox(0.0F, -1.5F, 0.0F, 0, 3, 5);
/*  86 */     this.Pectoralfin4.setRotationPoint(2.0F, 14.0F, 1.0F);
/*  87 */     this.Pectoralfin4.setTextureSize(64, 64);
/*  88 */     this.Pectoralfin4.mirror = true;
/*  89 */     setRotation(this.Pectoralfin4, -0.2974289F, 0.3346145F, 0.0F);
/*  90 */     this.Bottomfin = new ModelRenderer(this, 20, 8);
/*  91 */     this.Bottomfin.addBox(0.0F, 2.0F, 6.0F, 0, 3, 4);
/*  92 */     this.Bottomfin.setRotationPoint(0.0F, 14.0F, -5.0F);
/*  93 */     this.Bottomfin.setTextureSize(64, 64);
/*  94 */     this.Bottomfin.mirror = true;
/*  95 */     setRotation(this.Bottomfin, 0.0F, 0.0F, 0.0F);
/*  96 */     this.Tail1 = new ModelRenderer(this, 29, 15);
/*  97 */     this.Tail1.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 6);
/*  98 */     this.Tail1.setRotationPoint(0.0F, 14.0F, 5.0F);
/*  99 */     this.Tail1.setTextureSize(64, 64);
/* 100 */     this.Tail1.mirror = true;
/* 101 */     setRotation(this.Tail1, 0.0F, 0.0F, 0.0F);
/* 102 */     this.Tail2 = new ModelRenderer(this, 0, 8);
/* 103 */     this.Tail2.addBox(-1.0F, -1.5F, 6.0F, 2, 3, 4);
/* 104 */     this.Tail2.setRotationPoint(0.0F, 14.0F, 5.0F);
/* 105 */     this.Tail2.setTextureSize(64, 64);
/* 106 */     this.Tail2.mirror = true;
/* 107 */     setRotation(this.Tail2, 0.0F, 0.0F, 0.0F);
/* 108 */     this.Caudalfin1 = new ModelRenderer(this, 13, 35);
/* 109 */     this.Caudalfin1.addBox(-0.5F, 5.5F, 6.0F, 1, 3, 4);
/* 110 */     this.Caudalfin1.setRotationPoint(0.0F, 14.0F, 5.0F);
/* 111 */     this.Caudalfin1.setTextureSize(64, 64);
/* 112 */     this.Caudalfin1.mirror = true;
/* 113 */     setRotation(this.Caudalfin1, 0.8179294F, 0.0F, 0.0F);
/* 114 */     this.Caudalfin2 = new ModelRenderer(this, 15, 35);
/* 115 */     this.Caudalfin2.addBox(-0.5F, 5.5F, 6.0F, 1, 4, 3);
/* 116 */     this.Caudalfin2.setRotationPoint(0.0F, 14.0F, 5.0F);
/* 117 */     this.Caudalfin2.setTextureSize(64, 64);
/* 118 */     this.Caudalfin2.mirror = true;
/* 119 */     setRotation(this.Caudalfin2, 0.8179294F, 0.0F, 0.0F);
/* 120 */     this.Bottomfin1 = new ModelRenderer(this, 20, 0);
/* 121 */     this.Bottomfin1.addBox(-1.0F, 2.0F, 1.0F, 0, 5, 2);
/* 122 */     this.Bottomfin1.setRotationPoint(0.0F, 14.0F, -5.0F);
/* 123 */     this.Bottomfin1.setTextureSize(64, 64);
/* 124 */     this.Bottomfin1.mirror = true;
/* 125 */     setRotation(this.Bottomfin1, 0.2974289F, 0.0F, 0.3346145F);
/* 126 */     this.Bottomfin2 = new ModelRenderer(this, 20, 0);
/* 127 */     this.Bottomfin2.addBox(1.0F, 2.0F, 1.0F, 0, 5, 2);
/* 128 */     this.Bottomfin2.setRotationPoint(0.0F, 14.0F, -5.0F);
/* 129 */     this.Bottomfin2.setTextureSize(64, 64);
/* 130 */     this.Bottomfin2.mirror = true;
/* 131 */     setRotation(this.Bottomfin2, 0.2974289F, 0.0F, -0.3346075F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 136 */     float newangle = 0.0F;
/* 137 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 138 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 141 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.15F;
/* 142 */     this.Pectoralfin1.rotateAngleY = 0.4F + newangle;
/* 143 */     newangle = MathHelper.cos(f2 * 1.2F * this.wingspeed) * 3.1415927F * 0.15F;
/* 144 */     this.Pectoralfin2.rotateAngleY = -0.4F + newangle;
/* 145 */     newangle = MathHelper.cos(f2 * 1.1F * this.wingspeed) * 3.1415927F * 0.15F;
/* 146 */     this.Pectoralfin3.rotateAngleY = 0.4F + newangle;
/* 147 */     newangle = MathHelper.cos(f2 * 1.0F * this.wingspeed) * 3.1415927F * 0.15F;
/* 148 */     this.Pectoralfin4.rotateAngleY = -0.4F + newangle;
/*     */     
/* 150 */     newangle = MathHelper.cos(f2 * 1.7F * this.wingspeed) * 3.1415927F * 0.25F;
/* 151 */     this.Bottomfin1.rotateAngleY = newangle;
/* 152 */     this.Bottomfin2.rotateAngleY = -newangle;
/*     */     
/* 154 */     newangle = MathHelper.cos(f2 * 0.7F * this.wingspeed) * 3.1415927F * 0.1F;
/* 155 */     this.Jaw.rotateAngleX = -0.25F + newangle;
/*     */ 
/*     */     
/* 158 */     this.Body.render(f5);
/* 159 */     this.Head.render(f5);
/* 160 */     this.Dorsalfin.render(f5);
/* 161 */     this.Mouth.render(f5);
/* 162 */     this.Jaw.render(f5);
/* 163 */     this.Pectoralfin1.render(f5);
/* 164 */     this.Pectoralfin2.render(f5);
/* 165 */     this.Pectoralfin3.render(f5);
/* 166 */     this.Pectoralfin4.render(f5);
/* 167 */     this.Bottomfin.render(f5);
/* 168 */     this.Tail1.render(f5);
/* 169 */     this.Tail2.render(f5);
/* 170 */     this.Caudalfin1.render(f5);
/* 171 */     this.Caudalfin2.render(f5);
/* 172 */     this.Bottomfin1.render(f5);
/* 173 */     this.Bottomfin2.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 179 */     model.rotateAngleX = x;
/* 180 */     model.rotateAngleY = y;
/* 181 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 186 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelGoldFish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */