/*     */ package danger.orespawn.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelDragonfly extends ModelBase {
/*   9 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer lfwing;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer rjaw;
/*     */   ModelRenderer ljaw;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer Shape10;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
/*     */   ModelRenderer Shape15;
/*     */   ModelRenderer Shape16;
/*     */   ModelRenderer Shape17;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape19;
/*     */   ModelRenderer Shape20;
/*     */   ModelRenderer Shape21;
/*     */   ModelRenderer Shape22;
/*     */   ModelRenderer Shape23;
/*     */   ModelRenderer lrwing;
/*     */   ModelRenderer rfwing;
/*     */   ModelRenderer rrwing;
/*     */   
/*     */   public ModelDragonfly(float f1) {
/*  39 */     this.wingspeed = f1;
/*     */     
/*  41 */     this.textureWidth = 64;
/*  42 */     this.textureHeight = 64;
/*     */     
/*  44 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  45 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 5, 4, 7);
/*  46 */     this.Shape1.setRotationPoint(0.0F, 16.0F, 0.0F);
/*  47 */     this.Shape1.setTextureSize(64, 64);
/*  48 */     this.Shape1.mirror = true;
/*  49 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  50 */     this.lfwing = new ModelRenderer(this, 0, 33);
/*  51 */     this.lfwing.addBox(0.0F, 0.0F, 0.0F, 10, 1, 3);
/*  52 */     this.lfwing.setRotationPoint(5.0F, 16.0F, 1.0F);
/*  53 */     this.lfwing.setTextureSize(64, 64);
/*  54 */     this.lfwing.mirror = true;
/*  55 */     setRotation(this.lfwing, 0.0F, 0.4886922F, 0.0F);
/*  56 */     this.Shape3 = new ModelRenderer(this, 0, 13);
/*  57 */     this.Shape3.addBox(-2.0F, 0.0F, -4.0F, 4, 3, 4);
/*  58 */     this.Shape3.setRotationPoint(2.5F, 16.0F, -1.0F);
/*  59 */     this.Shape3.setTextureSize(64, 64);
/*  60 */     this.Shape3.mirror = true;
/*  61 */     setRotation(this.Shape3, 0.4886922F, 0.0F, 0.0F);
/*  62 */     this.Shape4 = new ModelRenderer(this, 9, 21);
/*  63 */     this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
/*  64 */     this.Shape4.setRotationPoint(1.0F, 18.0F, -6.0F);
/*  65 */     this.Shape4.setTextureSize(64, 64);
/*  66 */     this.Shape4.mirror = true;
/*  67 */     setRotation(this.Shape4, 0.4886922F, 0.1745329F, 0.0F);
/*  68 */     this.Shape5 = new ModelRenderer(this, 0, 21);
/*  69 */     this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
/*  70 */     this.Shape5.setRotationPoint(3.0F, 18.0F, -6.0F);
/*  71 */     this.Shape5.setTextureSize(64, 64);
/*  72 */     this.Shape5.mirror = true;
/*  73 */     setRotation(this.Shape5, 0.4886922F, -0.1745329F, 0.0F);
/*  74 */     this.rjaw = new ModelRenderer(this, 0, 27);
/*  75 */     this.rjaw.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
/*  76 */     this.rjaw.setRotationPoint(2.0F, 19.0F, -5.0F);
/*  77 */     this.rjaw.setTextureSize(64, 64);
/*  78 */     this.rjaw.mirror = true;
/*  79 */     setRotation(this.rjaw, 0.4363323F, 0.1745329F, 0.0F);
/*  80 */     this.ljaw = new ModelRenderer(this, 5, 27);
/*  81 */     this.ljaw.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/*  82 */     this.ljaw.setRotationPoint(3.0F, 19.0F, -5.0F);
/*  83 */     this.ljaw.setTextureSize(64, 64);
/*  84 */     this.ljaw.mirror = true;
/*  85 */     setRotation(this.ljaw, 0.4363323F, -0.1745329F, 0.0F);
/*  86 */     this.tail1 = new ModelRenderer(this, 25, 0);
/*  87 */     this.tail1.addBox(-1.0F, 0.0F, 0.0F, 3, 3, 7);
/*  88 */     this.tail1.setRotationPoint(2.0F, 16.0F, 7.0F);
/*  89 */     this.tail1.setTextureSize(64, 64);
/*  90 */     this.tail1.mirror = true;
/*  91 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/*  92 */     this.tail2 = new ModelRenderer(this, 25, 11);
/*  93 */     this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 9);
/*  94 */     this.tail2.setRotationPoint(2.0F, 16.0F, 14.0F);
/*  95 */     this.tail2.setTextureSize(64, 64);
/*  96 */     this.tail2.mirror = true;
/*  97 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/*  98 */     this.Shape10 = new ModelRenderer(this, 23, 0);
/*  99 */     this.Shape10.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1);
/* 100 */     this.Shape10.setRotationPoint(1.0F, 18.0F, 0.0F);
/* 101 */     this.Shape10.setTextureSize(64, 64);
/* 102 */     this.Shape10.mirror = true;
/* 103 */     setRotation(this.Shape10, -0.2792527F, 0.0F, 0.3490659F);
/* 104 */     this.Shape11 = new ModelRenderer(this, 40, 0);
/* 105 */     this.Shape11.addBox(0.0F, 0.0F, -4.0F, 1, 1, 4);
/* 106 */     this.Shape11.setRotationPoint(-1.0F, 21.0F, 0.0F);
/* 107 */     this.Shape11.setTextureSize(64, 64);
/* 108 */     this.Shape11.mirror = true;
/* 109 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/* 110 */     this.Shape12 = new ModelRenderer(this, 18, 12);
/* 111 */     this.Shape12.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
/* 112 */     this.Shape12.setRotationPoint(0.0F, 21.0F, -4.0F);
/* 113 */     this.Shape12.setTextureSize(64, 64);
/* 114 */     this.Shape12.mirror = true;
/* 115 */     setRotation(this.Shape12, 0.0F, 0.0F, -0.1919862F);
/* 116 */     this.Shape13 = new ModelRenderer(this, 18, 0);
/* 117 */     this.Shape13.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
/* 118 */     this.Shape13.setRotationPoint(4.0F, 18.0F, 0.0F);
/* 119 */     this.Shape13.setTextureSize(64, 64);
/* 120 */     this.Shape13.mirror = true;
/* 121 */     setRotation(this.Shape13, -0.2792527F, 0.0F, -0.3490659F);
/* 122 */     this.Shape14 = new ModelRenderer(this, 51, 0);
/* 123 */     this.Shape14.addBox(0.0F, 0.0F, -4.0F, 1, 1, 4);
/* 124 */     this.Shape14.setRotationPoint(5.0F, 21.0F, 0.0F);
/* 125 */     this.Shape14.setTextureSize(64, 64);
/* 126 */     this.Shape14.mirror = true;
/* 127 */     setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
/* 128 */     this.Shape15 = new ModelRenderer(this, 13, 12);
/* 129 */     this.Shape15.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 130 */     this.Shape15.setRotationPoint(5.0F, 21.0F, -4.0F);
/* 131 */     this.Shape15.setTextureSize(64, 64);
/* 132 */     this.Shape15.mirror = true;
/* 133 */     setRotation(this.Shape15, 0.0F, 0.0F, 0.1919862F);
/* 134 */     this.Shape16 = new ModelRenderer(this, 9, 53);
/* 135 */     this.Shape16.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 136 */     this.Shape16.setRotationPoint(5.0F, 19.5F, 3.0F);
/* 137 */     this.Shape16.setTextureSize(64, 64);
/* 138 */     this.Shape16.mirror = true;
/* 139 */     setRotation(this.Shape16, 0.0F, 0.0F, 0.6457718F);
/* 140 */     this.Shape17 = new ModelRenderer(this, 0, 56);
/* 141 */     this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 142 */     this.Shape17.setRotationPoint(6.0F, 21.0F, 3.0F);
/* 143 */     this.Shape17.setTextureSize(64, 64);
/* 144 */     this.Shape17.mirror = true;
/* 145 */     setRotation(this.Shape17, 0.0F, 0.0F, 0.0F);
/* 146 */     this.Shape18 = new ModelRenderer(this, 0, 53);
/* 147 */     this.Shape18.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 1);
/* 148 */     this.Shape18.setRotationPoint(0.0F, 19.5F, 3.0F);
/* 149 */     this.Shape18.setTextureSize(64, 64);
/* 150 */     this.Shape18.mirror = true;
/* 151 */     setRotation(this.Shape18, 0.0F, 0.0F, -0.6457718F);
/* 152 */     this.Shape19 = new ModelRenderer(this, 5, 56);
/* 153 */     this.Shape19.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
/* 154 */     this.Shape19.setRotationPoint(-1.0F, 21.0F, 3.0F);
/* 155 */     this.Shape19.setTextureSize(64, 64);
/* 156 */     this.Shape19.mirror = true;
/* 157 */     setRotation(this.Shape19, 0.0F, 0.0F, 0.0F);
/* 158 */     this.Shape20 = new ModelRenderer(this, 9, 61);
/* 159 */     this.Shape20.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 160 */     this.Shape20.setRotationPoint(4.0F, 19.5F, 6.0F);
/* 161 */     this.Shape20.setTextureSize(64, 64);
/* 162 */     this.Shape20.mirror = true;
/* 163 */     setRotation(this.Shape20, 0.0F, -0.6457718F, 0.5061455F);
/* 164 */     this.Shape21 = new ModelRenderer(this, 0, 61);
/* 165 */     this.Shape21.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
/* 166 */     this.Shape21.setRotationPoint(1.5F, 19.5F, 7.0F);
/* 167 */     this.Shape21.setTextureSize(64, 64);
/* 168 */     this.Shape21.mirror = true;
/* 169 */     setRotation(this.Shape21, 0.0F, -2.391101F, 0.5061455F);
/* 170 */     this.Shape22 = new ModelRenderer(this, 0, 0);
/* 171 */     this.Shape22.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 172 */     this.Shape22.setRotationPoint(-1.0F, 21.0F, 7.5F);
/* 173 */     this.Shape22.setTextureSize(64, 64);
/* 174 */     this.Shape22.mirror = true;
/* 175 */     setRotation(this.Shape22, 0.0F, 0.0F, 0.0F);
/* 176 */     this.Shape23 = new ModelRenderer(this, 0, 13);
/* 177 */     this.Shape23.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
/* 178 */     this.Shape23.setRotationPoint(5.0F, 21.0F, 7.5F);
/* 179 */     this.Shape23.setTextureSize(64, 64);
/* 180 */     this.Shape23.mirror = true;
/* 181 */     setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
/* 182 */     this.lrwing = new ModelRenderer(this, 0, 38);
/* 183 */     this.lrwing.addBox(0.0F, 0.0F, -3.0F, 10, 1, 3);
/* 184 */     this.lrwing.setRotationPoint(5.0F, 16.0F, 6.0F);
/* 185 */     this.lrwing.setTextureSize(64, 64);
/* 186 */     this.lrwing.mirror = true;
/* 187 */     setRotation(this.lrwing, 0.0F, -0.3839724F, 0.0F);
/* 188 */     this.rfwing = new ModelRenderer(this, 0, 48);
/* 189 */     this.rfwing.addBox(-10.0F, 0.0F, 0.0F, 10, 1, 3);
/* 190 */     this.rfwing.setRotationPoint(0.0F, 16.0F, 1.0F);
/* 191 */     this.rfwing.setTextureSize(64, 64);
/* 192 */     this.rfwing.mirror = true;
/* 193 */     setRotation(this.rfwing, 0.0F, -0.4886922F, 0.0F);
/* 194 */     this.rrwing = new ModelRenderer(this, 0, 43);
/* 195 */     this.rrwing.addBox(-10.0F, 0.0F, -3.0F, 10, 1, 3);
/* 196 */     this.rrwing.setRotationPoint(0.0F, 16.0F, 6.0F);
/* 197 */     this.rrwing.setTextureSize(64, 64);
/* 198 */     this.rrwing.mirror = true;
/* 199 */     setRotation(this.rrwing, 0.0F, 0.3839724F, 0.0F);
/*     */   }
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 203 */     float newangle = 0.0F;
/* 204 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 205 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 208 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/* 209 */     this.lfwing.rotateAngleZ = newangle;
/* 210 */     this.rfwing.rotateAngleZ = -newangle;
/* 211 */     this.lrwing.rotateAngleZ = newangle + 3.14F;
/* 212 */     this.rrwing.rotateAngleZ = -newangle + 3.14F;
/*     */     
/* 214 */     newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.1F;
/* 215 */     this.ljaw.rotateAngleX = newangle;
/* 216 */     this.rjaw.rotateAngleX = -newangle;
/*     */     
/* 218 */     this.Shape1.render(f5);
/* 219 */     this.lfwing.render(f5);
/* 220 */     this.Shape3.render(f5);
/* 221 */     this.Shape4.render(f5);
/* 222 */     this.Shape5.render(f5);
/* 223 */     this.rjaw.render(f5);
/* 224 */     this.ljaw.render(f5);
/* 225 */     this.tail1.render(f5);
/* 226 */     this.tail2.render(f5);
/* 227 */     this.Shape10.render(f5);
/* 228 */     this.Shape11.render(f5);
/* 229 */     this.Shape12.render(f5);
/* 230 */     this.Shape13.render(f5);
/* 231 */     this.Shape14.render(f5);
/* 232 */     this.Shape15.render(f5);
/* 233 */     this.Shape16.render(f5);
/* 234 */     this.Shape17.render(f5);
/* 235 */     this.Shape18.render(f5);
/* 236 */     this.Shape19.render(f5);
/* 237 */     this.Shape20.render(f5);
/* 238 */     this.Shape21.render(f5);
/* 239 */     this.Shape22.render(f5);
/* 240 */     this.Shape23.render(f5);
/* 241 */     this.lrwing.render(f5);
/* 242 */     this.rfwing.render(f5);
/* 243 */     this.rrwing.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 249 */     model.rotateAngleX = x;
/* 250 */     model.rotateAngleY = y;
/* 251 */     model.rotateAngleZ = z;
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 255 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\model\ModelDragonfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */