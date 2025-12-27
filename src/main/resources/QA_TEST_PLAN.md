# Mod QA Test Plan: Cheese Nuggests

**Mod ID:** `cheesenuggests`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T01:06:28.526Z
**Total Tests:** 8

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p cheesenuggests:cheese_nugget
/give @p cheesenuggests:cheese_sword
```

## Items

### 🤖 Cheese Nugget Registration

**Command:** `/give @p cheesenuggests:cheese_nugget`

**Steps:**
1. Run: /give @p cheesenuggests:cheese_nugget
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Cheese Sword Registration

**Command:** `/give @p cheesenuggests:cheese_sword`

**Steps:**
1. Run: /give @p cheesenuggests:cheese_sword
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Cheese Nugget Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:iron_ore"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Cheese Nugget

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Cheese Sword Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Cheese Sword

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Cheese Sword on_hit Effect

**Steps:**
1. Give yourself the item: /give @p cheesenuggests:cheese_sword
2. Hit a mob with the item
3. Observe minecraft:slowness activation

**Expected:** minecraft:slowness activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Cheese Block Placement

**Command:** `/give @p cheesenuggests:cheese_block`

**Steps:**
1. Run: /give @p cheesenuggests:cheese_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Cheese Ore Placement

**Command:** `/give @p cheesenuggests:cheese_ore`

**Steps:**
1. Run: /give @p cheesenuggests:cheese_ore
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Cheese Ore Block Placement

**Command:** `/give @p cheesenuggests:cheese_ore_block`

**Steps:**
1. Run: /give @p cheesenuggests:cheese_ore_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 2 | [ ] | [ ] |
| Recipes | 2 | [ ] | [ ] |
| Item Effects | 1 | [ ] | [ ] |
| Blocks | 3 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_